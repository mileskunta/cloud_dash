package com.ezhupai.service;

import com.ezhupai.persistence.dao.CoronaInfoDao;
import com.ezhupai.persistence.model.CoronaDataEntity;
import com.ezhupai.vo.CoronaDataDto;
import com.ezhupai.vo.CoronaOrgVo;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import sun.net.www.http.HttpClient;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CoronaService {

    private enum Level {
        Country, Province, City
    }

    @Autowired
    private CoronaInfoDao dao;

    public List<CoronaDataEntity> findAll() {
        return dao.findAll();
    }

    public List<CoronaDataEntity> findByCountry(String countryCode) {
        return dao.findByCountryCode(countryCode);
    }

    public List<CoronaDataEntity> findProvinceData(String country, String province) {
        return dao.findProvinceData(country, province);
    }

    public List<CoronaDataEntity> findCityData(String country, String province, String city) {
        return dao.findCityData(country, province, city);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    public List<CoronaOrgVo> getWorldwideStatus() {
        List<CoronaDataEntity> dataEntities = this.dao.getWorldLevelData();
        List<CoronaOrgVo> countryData = this.worldDataGroupByLevel(dataEntities, Level.Country);
        for (CoronaOrgVo vo : countryData) {
            System.out.println(vo.getCountry());
        }
        return countryData;
    }

    public List<CoronaOrgVo> getCountryStatus(String country) {
        List<CoronaDataEntity> dataEntities = this.dao.getCountryLevelData(country);
        List<CoronaOrgVo> countryData = this.worldDataGroupByLevel(dataEntities, Level.Province);
        return countryData;
    }

    public List<CoronaOrgVo> getProvinceStatus(String country, String province) {
        List<CoronaDataEntity> dataEntities = this.dao.getProvinceLevelData(country, province);
        List<CoronaOrgVo> countryData = this.worldDataGroupByLevel(dataEntities, Level.City);
        return countryData;
    }

//    public List<CoronaOrgVo> getCityStatus(String country, String province, String city) {
//        List<CoronaDataEntity> dataEntities = this.dao.getCityLevelData(country, province,city);
//        List<CoronaOrgVo> countryData = this.worldDataGroupByLevel(dataEntities, Level.City);
//        return countryData;
//    }


    private List<CoronaOrgVo> worldDataGroupByLevel(List<CoronaDataEntity> dataEntities, Level level) {
        List<CoronaOrgVo> vos = new ArrayList<CoronaOrgVo>();
        Map<String, List<CoronaDataEntity>> countries = dataEntities.stream().collect(Collectors.groupingBy(entity -> {
            switch (level) {
                case Country:
                    return entity.getCountry();
                case Province:
                    return entity.getCountry() + "-" + entity.getProvince();
                case City:
                    return entity.getCountry() + "-" + entity.getProvince() + "-" + entity.getCity();
            }
            throw new RuntimeException("invalid Level");
        }));
        for (String country : countries.keySet()) {
            vos.add(new CoronaOrgVo(countries.get(country)));
        }
        return vos;
    }


    public List<CoronaDataEntity> updateCoronaData(int year, int month, int day) {
        Date date = new GregorianCalendar(year, month - 1, day).getTime();

        List<CoronaDataDto> raw = this.getLatestData(date);
        List<CoronaDataEntity> entities = this.dao.findByDate(date);
        return this.updateCoronaDB(entities, raw);
    }

    private List<CoronaDataEntity> updateCoronaDB(List<CoronaDataEntity> entities, List<CoronaDataDto> raw) {


        raw.stream().forEach(dto -> {
            dto.setProvince(dto.getProvince() == null ? "" : dto.getProvince());
            dto.setProvinceCode(dto.getProvinceCode() == null ? "" : dto.getProvinceCode());
            dto.setCity(dto.getCity() == null ? "" : dto.getCity());
            dto.setCityCode(dto.getCityCode() == null ? "" : dto.getCityCode());
            dto.setCountry(dto.getCountry() == null ? "" : dto.getCountry());
            dto.setCountryCode(dto.getCountryCode() == null ? "" : dto.getCountryCode());
        });

        Map<String, CoronaDataDto> dtoMap = raw.stream().collect(Collectors.toMap(CoronaDataDto::getKey, CoronaDataDto::getInstance));


        List<CoronaDataEntity> newEntity = new ArrayList<>();
        entities.stream().forEach(entity -> {
            String key = entity.getCountry() + "-" + entity.getProvince() + "-" + entity.getCity();
            CoronaDataDto dto = dtoMap.get(key);
            if (dto != null) {
                System.out.println("entity: " + key + "   ::   " + dto.getKey());

                entity.setConfirmed(dto.getConfirmed());
                entity.setCured(dto.getCured());
                entity.setSuspected(dto.getSuspected());
                entity.setDead(dto.getDead());
                dtoMap.remove(key);
            } else {
                System.out.println("entity not found: " + key);
            }
        });

        for (CoronaDataDto dto : dtoMap.values()) {
            System.out.println("entity created:" + dto.getKey());
            CoronaDataEntity entity1 = new CoronaDataEntity();
            entity1.setDate(dto.getDate());
            entity1.setSuspected(dto.getSuspected());
            entity1.setCured(dto.getCured());
            entity1.setConfirmed(dto.getConfirmed());
            entity1.setDead(dto.getDead());
            entity1.setCity(dto.getCity());
            entity1.setCityCode(dto.getCityCode());
            entity1.setProvince(dto.getProvince());
            entity1.setProvinceCode(dto.getProvinceCode());
            entity1.setCountry(dto.getCountry());
            entity1.setCountryCode(dto.getCountryCode());
            newEntity.add(entity1);
        }

        entities.addAll(newEntity);
        this.dao.save(entities);

        return entities;
    }

    //tomcat log.properties, java.util.logging.ConsoleHandler.encoding = GBK
    public List<CoronaDataDto> getLatestData(Date date) {
        List<CoronaDataDto> list = null;
        CsvToBeanBuilder<CoronaDataDto> beanBuilder = null;
        try {

            boolean remote = false;
            if (remote) {
                HttpClient client = new HttpClient();
                GetMethod getMethod = new GetMethod("https://raw.githubusercontent.com/canghailan/Wuhan-2019-nCoV/master/Wuhan-2019-nCoV.csv");
                int code = client.executeMethod(getMethod);
                if (code == 200) {
                    beanBuilder = new CsvToBeanBuilder<>(new InputStreamReader(getMethod.getResponseBodyAsStream()));
                }
            } else {
                File file = new File("C:\\Users\\fgeng\\Desktop\\Wuhan-2019-nCoV.csv");
                beanBuilder = new CsvToBeanBuilder<>(new InputStreamReader(new FileInputStream(file), "utf-8"));
            }
            beanBuilder.withType(CoronaDataDto.class);
            CsvToBean<CoronaDataDto> ctb = beanBuilder.build();
            ctb.setFilter(new CsvToBeanFilter() {
                @Override
                public boolean allowLine(String[] strings) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dateStr = sdf.format(date);
                    boolean match = dateStr.equals(strings[0]);
                    return match;
                }
            });
            list = ctb.parse();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }


    public static void main(String[] args) {
        CoronaService service = new CoronaService();
        service.updateCoronaData(2020, 3, 21);
    }
}

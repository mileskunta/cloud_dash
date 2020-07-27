package com.ezhupai.persistence.dao;

import com.ezhupai.persistence.model.BiddingInfoEntity;
import com.ezhupai.persistence.model.CoronaDataEntity;
import com.ezhupai.persistence.model.HupaiPinEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CoronaInfoDao extends CrudRepository<CoronaDataEntity, Integer> {

    CoronaDataEntity findOne(Integer id);

    List<CoronaDataEntity> findAll();

    List<CoronaDataEntity> findByCountryCode(String countryCode);

    List<CoronaDataEntity> findByDate(Date date);

    String FIND_BY_CITY_SQL = "select * from coruna_global_data where country = ?1 and province = ?2 and city = ?3 ";
    @Query(value = FIND_BY_PROVINCE_SQL, nativeQuery = true)
    List<CoronaDataEntity> findCityData(String country, String province, String city);


    String FIND_BY_PROVINCE_SQL = "select * from coruna_global_data where country = ?1 and province = ?2 and city = '' ";
    @Query(value = FIND_BY_PROVINCE_SQL, nativeQuery = true)
    List<CoronaDataEntity> findProvinceData(String country, String province);





//////////////////////////////////////////////////////////////////////////////////////////////
    String WORLD_LEVEL_DATA_SQL = "select * from coruna_global_data where (province = '' or province is null) and DATE_SUB(CURDATE(), INTERVAL 30 DAY) < date(date);";
    @Query(value = WORLD_LEVEL_DATA_SQL, nativeQuery = true)
    List<CoronaDataEntity> getWorldLevelData();

    String COUNTRY_LEVEL_DATA_SQL = "select * from coruna_global_data where country = ?1 and (province = '' or province is null)  and (city = '' or city is null) and DATE_SUB(CURDATE(), INTERVAL 5 DAY) < date(date);";
    @Query(value = COUNTRY_LEVEL_DATA_SQL, nativeQuery = true)
    List<CoronaDataEntity> getCountryLevelData(String country);

    String PROVINCE_LEVEL_DATA_SQL = "select * from coruna_global_data where country = ?1 and province = ?2  and (city = '' or city is null) and DATE_SUB(CURDATE(), INTERVAL 5 DAY) < date(date);";
    @Query(value = PROVINCE_LEVEL_DATA_SQL, nativeQuery = true)
    List<CoronaDataEntity> getProvinceLevelData(String country, String province);

    String CITY_LEVEL_DATA_SQL = "select * from coruna_global_data where country = ?1 and province = ?2  and city=3? and DATE_SUB(CURDATE(), INTERVAL 5 DAY) < date(date);";
    @Query(value = CITY_LEVEL_DATA_SQL, nativeQuery = true)
    List<CoronaDataEntity> getCityLevelData (String country, String province, String city);
}

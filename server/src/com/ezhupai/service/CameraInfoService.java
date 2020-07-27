package com.ezhupai.service;

import com.ezhupai.persistence.dao.CameraInfoDao;
import com.ezhupai.persistence.dao.FeedbackItemDao;
import com.ezhupai.persistence.model.CameraInfoEntity;
import com.ezhupai.persistence.model.FeedbackItemEntity;
import com.ezhupai.vo.CameraInfoResponseVo;
import com.ezhupai.vo.FeedbackItemVo;
import com.ezhupai.vo.sh122.GpsInfo;
import com.ezhupai.vo.sh122.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/12.
 */
@Service
public class CameraInfoService {
    @Autowired
    CameraInfoDao dao;

    public List<CameraInfoEntity> getAllCameraInfo() {
        return dao.findAll();
    }

//    public List<CameraInfoEntity> findCameraInfoLocationContain(String location){
//        return dao.findCameraInfoEntityByLocationIsContaining(location);
//    }

    public List<CameraInfoEntity> findCameraInfoPositionBetween(String longitudeFrom, String longitudeTo, String latitudeFrom, String latitudeTo) {
        return dao.findCameraInfoEntityByLongitudeBetweenAndLatitudeBetween(longitudeFrom, longitudeTo, latitudeFrom, latitudeTo);
    }

    public CameraInfoResponseVo findCameraInfoByLocation(String location, int start, int limit) {
        PageRequest request = new PageRequest(start, limit);
        Page<CameraInfoEntity> page = dao.findCameraInfoEntityByLocationIsContaining(location, request);
        CameraInfoResponseVo vo = new CameraInfoResponseVo();
        vo.setTotalItems((int) page.getTotalElements());
        vo.setCurrentPage(page.getNumber() + 1);
        vo.setPageSize(limit);
        vo.setCameraInfoList(page.getContent());
        return vo;
    }

    @Transactional(readOnly = false, value = "transactionManager")
    public CameraInfoEntity updateGaodePosition(int id) {
        CameraInfoEntity entity = this.dao.findOne(id);
        double PI = 3.14159265358979324 * 3000.0 / 180.0;
        double x = Double.parseDouble(entity.getLongitude()) - 0.0065;
        double y = Double.parseDouble(entity.getLatitude()) - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * PI);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * PI);
        entity.setGaodeLongt(Double.toString(z * Math.cos(theta)));
        entity.setGaodeLat(Double.toString(z * Math.sin(theta)));
        return this.dao.save(entity);
    }

    public void updateGaodePositions() {
        List<CameraInfoEntity> entities = this.dao.findAll();
        ResponseVo sr = WebRequester.sendPost("http://sh.122.gov.cn/m/placesitectrl/loadBusincessList", "city=沪A&page=1&size=100000&wdlxdm=29&ywfw=");
        List<CameraInfoEntity> newEntities = new ArrayList<CameraInfoEntity>();
        for (GpsInfo info : sr.getData().getContent()) {
            boolean exist = false;
            for (CameraInfoEntity existingEntity : entities) {
                if (existingEntity.getUniqId().equals(info.getWddm())) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                CameraInfoEntity entity = new CameraInfoEntity();
                entity.setCarPlate(info.getFzjg());
                entity.setCity("上海");
                String gps = info.getGps();
                entity.setLongitude(gps.split(",")[0].trim());
                entity.setLatitude(gps.split(",")[1].trim());
                entity.setLocation(info.getWdmc());
                entity.setUniqId(info.getWddm());
                newEntities.add(entity);
            }
        }

        this.dao.save(newEntities);
    }
}

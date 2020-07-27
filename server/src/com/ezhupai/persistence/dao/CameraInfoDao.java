package com.ezhupai.persistence.dao;

import com.ezhupai.persistence.model.BiddingInfoEntity;
import com.ezhupai.persistence.model.CameraInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
@Repository
public interface CameraInfoDao extends PagingAndSortingRepository<CameraInfoEntity, Integer> {
    CameraInfoEntity findOne(int id);

    List<CameraInfoEntity> findAll();

//    List<CameraInfoEntity> findCameraInfoEntityByLocationIsContaining(String location);

//    List<CameraInfoEntity> findCameraInfoEntityByLongitudeBetweenAndLatitudeBetween(String longitudeFrom, String longitudeTo,String latitudeFrom, String latitudeTo);
//    List<CameraInfoEntity> findCameraInfoEntityByLongtBetweenAndGaodeLatBetween(String longitudeFrom, String longitudeTo,String latitudeFrom, String latitudeTo);
List<CameraInfoEntity> findCameraInfoEntityByLongitudeBetweenAndLatitudeBetween(String longitudeFrom, String longitudeTo,String latitudeFrom, String latitudeTo);
//    List<CameraInfoEntity> findCameraInfoEntityByLongitude(String longitudeFrom, String longitudeTo,String latitudeFrom, String latitudeTo);



    Page<CameraInfoEntity> findCameraInfoEntityByLocationIsContaining(String location, Pageable pageable);

}

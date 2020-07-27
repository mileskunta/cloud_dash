package com.ezhupai.persistence.model;

import com.ezhupai.persistence.model.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2018/7/12.
 */
@Entity
@Table(name = "camera_info")
public class CameraInfoEntity extends BaseEntity {

    @Column(name = "location")
    private String location;

    @Column(name = "lontitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "gaode_lont")
    private String gaodeLongt;

    @Column(name = "gaode_lat")
    private String gaodeLat;

    @Column(name = "comment")
    private String comment;

    @Column(name = "city")
    private String city;

    @Column(name = "car_plate")
    private String carPlate;

    @Column(name = "uniq_id")
    private String uniqId;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getGaodeLongt() {
        return gaodeLongt;
    }

    public void setGaodeLongt(String gaodeLongt) {
        this.gaodeLongt = gaodeLongt;
    }

    public String getGaodeLat() {
        return gaodeLat;
    }

    public void setGaodeLat(String gaodeLat) {
        this.gaodeLat = gaodeLat;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getUniqId() {
        return uniqId;
    }

    public void setUniqId(String uniqId) {
        this.uniqId = uniqId;
    }
}

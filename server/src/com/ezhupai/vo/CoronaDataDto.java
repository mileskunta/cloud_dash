package com.ezhupai.vo;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import javax.persistence.Column;
import java.util.Date;

public class CoronaDataDto {

    //    @CsvBindByName(column = "code")
//    private String code;
//
//
//    @CsvBindByName(column = "name")
//    private String name;
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    @CsvDate("dd/MM/yyyy hh:mm:ss")
    @CsvDate("yyyy-MM-dd")
    @CsvBindByName(column = "date")
    private Date date;

    @CsvBindByName(column = "country")
    private String country;

    @CsvBindByName(column = "countryCode")
    private String countryCode;

    @CsvBindByName(column = "province")
    private String province;

    @CsvBindByName(column = "provinceCode")
    private String provinceCode;

    @CsvBindByName(column = "city")
    private String city;

    @CsvBindByName(column = "cityCode")
    private String cityCode;

    @CsvBindByName(column = "confirmed")
    private int confirmed;

    @CsvBindByName(column = "suspected")
    private int suspected;

    @CsvBindByName(column = "cured")
    private int cured;

    @CsvBindByName(column = "dead")
    private int dead;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getSuspected() {
        return suspected;
    }

    public void setSuspected(int suspected) {
        this.suspected = suspected;
    }

    public int getCured() {
        return cured;
    }

    public void setCured(int cured) {
        this.cured = cured;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public String getKey() {
        return this.country + "-" + this.province + "-" + this.city;
    }

    public CoronaDataDto getInstance(){
        return this;
    }
}

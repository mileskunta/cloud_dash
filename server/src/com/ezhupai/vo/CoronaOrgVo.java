package com.ezhupai.vo;

import com.ezhupai.persistence.model.CoronaDataEntity;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CoronaOrgVo {

    private String country;
    private String countryCode;
    private String province;
    private String provinceCode;
    private String city;
    private String cityCode;

    private int latestConfirmed;
    private int latestSuspected;
    private int latestCured;
    private int latestDead;
    private Date latestDataDate;
    private int latestDataYear;
    private int latestDataMonth;
    private int latestDataDay;


    private int confirmedIncrease;
    private int cureIncrease;
    private int suspendIncrease;
    private int deadIncrease;

    List<CoronaDailyDetailVo> trend = new ArrayList<CoronaDailyDetailVo>();


    public CoronaOrgVo (List<CoronaDataEntity> entities){
        if(!CollectionUtils.isEmpty(entities)) {
            CoronaDataEntity ele = entities.get(0);
            this.city = ele.getCity();
            this.country = ele.getCountry();
            this.countryCode=ele.getCountryCode();
            this.province=ele.getProvince();
            this.provinceCode=ele.getProvinceCode();
            this.city=ele.getCity();
            this.cityCode=ele.getCityCode();
            this.trend.addAll(entities.stream().map(entity->{
                CoronaDailyDetailVo vo = new CoronaDailyDetailVo(entity);
                return vo;
            }).sorted(Comparator.comparing(CoronaDailyDetailVo::getDate)).collect(Collectors.toList()));

            //calculate delta
            int trendLength = this.trend.size();
            CoronaDailyDetailVo latest = this.trend.get(trendLength -1);
            CoronaDailyDetailVo beforeLatest;
            if(trendLength > 1){
                beforeLatest = this.trend.get(trendLength-2);
            } else {
                beforeLatest = new CoronaDailyDetailVo(0);
            }

            this.confirmedIncrease = latest.getConfirmed() - beforeLatest.getConfirmed();
            this.suspendIncrease = latest.getSuspected() - beforeLatest.getSuspected();
            this.cureIncrease = latest.getCured() - beforeLatest.getCured();
            this.deadIncrease = latest.getDead() - beforeLatest.getDead();

            //latest Data
            this.latestConfirmed = latest.getConfirmed();
            this.latestSuspected = latest.getSuspected();
            this.latestCured  = latest.getCured();
            this.latestDead = latest.getDead();
            this.latestDataDate = latest.getDate();
            this.latestDataDay = latest.getDay();
            this.latestDataMonth = latest.getMonth();
            this.latestDataYear = latest.getYear();
        }
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

    public int getConfirmedIncrease() {
        return confirmedIncrease;
    }

    public void setConfirmedIncrease(int confirmedIncrease) {
        this.confirmedIncrease = confirmedIncrease;
    }

    public int getCureIncrease() {
        return cureIncrease;
    }

    public void setCureIncrease(int cureIncrease) {
        this.cureIncrease = cureIncrease;
    }

    public int getSuspendIncrease() {
        return suspendIncrease;
    }

    public void setSuspendIncrease(int suspendIncrease) {
        this.suspendIncrease = suspendIncrease;
    }

    public int getDeadIncrease() {
        return deadIncrease;
    }

    public void setDeadIncrease(int deadIncrease) {
        this.deadIncrease = deadIncrease;
    }

    public List<CoronaDailyDetailVo> getTrend() {
        if(trend == null){
            this.trend = new ArrayList<CoronaDailyDetailVo>();
        }
        return trend;
    }

    public void setTrend(List<CoronaDailyDetailVo> trend) {
        this.trend = trend;
    }

    public int getLatestConfirmed() {
        return latestConfirmed;
    }

    public void setLatestConfirmed(int latestConfirmed) {
        this.latestConfirmed = latestConfirmed;
    }

    public int getLatestSuspected() {
        return latestSuspected;
    }

    public void setLatestSuspected(int latestSuspected) {
        this.latestSuspected = latestSuspected;
    }

    public int getLatestCured() {
        return latestCured;
    }

    public void setLatestCured(int latestCured) {
        this.latestCured = latestCured;
    }

    public int getLatestDead() {
        return latestDead;
    }

    public void setLatestDead(int latestDead) {
        this.latestDead = latestDead;
    }

    public Date getLatestDataDate() {
        return latestDataDate;
    }

    public void setLatestDataDate(Date latestDataDate) {
        this.latestDataDate = latestDataDate;
    }

    public int getLatestDataYear() {
        return latestDataYear;
    }

    public void setLatestDataYear(int latestDataYear) {
        this.latestDataYear = latestDataYear;
    }

    public int getLatestDataMonth() {
        return latestDataMonth;
    }

    public void setLatestDataMonth(int latestDataMonth) {
        this.latestDataMonth = latestDataMonth;
    }

    public int getLatestDataDay() {
        return latestDataDay;
    }

    public void setLatestDataDay(int latestDataDay) {
        this.latestDataDay = latestDataDay;
    }
}

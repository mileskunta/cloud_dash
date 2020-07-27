package com.ezhupai.vo;

import com.ezhupai.persistence.model.BiddingInfoEntity;

/**
 * Created by Administrator on 2018/7/3.
 */
public class BiddingInfoVo {
    private int id;
    private String year;
    private String month;
    private String volume;
    private String price;
    private String average;
    private String lastBidSecond;
    private String lastBidOrder;
    private String totalBid;

    private String nextDate;
    private String companyVolume;
    private String personalVolume;

    public void toVo(BiddingInfoEntity entity){
        this.id = entity.getId();
        this.year = entity.getYear();
        this.month = entity.getMonth();
        this.average = entity.getAverage();
        this.volume = entity.getVolume();
        this.price  = entity.getPrice();
        this.lastBidSecond  = entity.getLastBidSecond();
        this.lastBidOrder = entity.getLastBidOrder();
        this.totalBid = entity.getTotalBid();
        this.nextDate = entity.getNextDate();
        this.companyVolume = entity.getCompanyVolume();
        this.personalVolume = entity.getPersonalVolume();
    }

    public BiddingInfoEntity toEntity (){
        BiddingInfoEntity entity=new BiddingInfoEntity();
        entity.setId(id);
        entity.setYear(year);
        entity.setMonth(month);
        entity.setAverage(average);
        entity.setVolume(volume);
        entity.setPrice(price);
        entity.setLastBidSecond(lastBidSecond);
        entity.setLastBidOrder(lastBidOrder);
        entity.setTotalBid(totalBid);
        entity.setNextDate(nextDate);
        entity.setCompanyVolume(companyVolume);
        entity.setPersonalVolume(personalVolume);
        return entity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getLastBidSecond() {
        return lastBidSecond;
    }

    public void setLastBidSecond(String lastBidSecond) {
        this.lastBidSecond = lastBidSecond;
    }

    public String getLastBidOrder() {
        return lastBidOrder;
    }

    public void setLastBidOrder(String lastBidOrder) {
        this.lastBidOrder = lastBidOrder;
    }

    public String getTotalBid() {
        return totalBid;
    }

    public void setTotalBid(String totalBid) {
        this.totalBid = totalBid;
    }

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }

    public String getCompanyVolume() {
        return companyVolume;
    }

    public void setCompanyVolume(String companyVolume) {
        this.companyVolume = companyVolume;
    }

    public String getPersonalVolume() {
        return personalVolume;
    }

    public void setPersonalVolume(String personalVolume) {
        this.personalVolume = personalVolume;
    }
}

package com.ezhupai.persistence.model;

import com.ezhupai.persistence.model.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2018/7/3.
 */
@Entity
@Table(name = "bidding_info")
public class BiddingInfoEntity extends BaseEntity {

    @Column(name = "year")
    private String year;
    @Column(name = "month")
    private String month;
    @Column(name = "volume")
    private String volume;
    @Column(name = "price")
    private String price;
    @Column(name = "average")
    private String average;
    @Column(name = "last_bidding_second")
    private String lastBidSecond;
    @Column(name = "last_bidding_order")
    private String lastBidOrder;
    @Column(name = "total_bid")
    private String totalBid;

    @Column(name = "next_date")
    private String nextDate;
    @Column(name = "company_volume")
    private String companyVolume;
    @Column(name = "personal_volume")
    private String personalVolume;

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
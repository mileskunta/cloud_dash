package com.ezhupai.persistence.model;

import com.ezhupai.persistence.model.common.BaseEntity;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/2/28.
 */
@Entity
@Table(name="hupai_helper_pin")
public class HupaiPinEntity extends BaseEntity {

    @Column(name="pin_code")
    private String pinCode;

    @Column(name="total_amount")
    private Integer buyCount;

    @Column(name="left_amount")
    private Integer leftTimes;

    @Column(name="used_records")
    private String usedRecords;

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getLeftTimes() {
        return leftTimes;
    }

    public void setLeftTimes(Integer leftTimes) {
        this.leftTimes = leftTimes;
    }

    public String getUsedRecords() {
        return usedRecords;
    }

    public void setUsedRecords(String usedRecords) {
        this.usedRecords = usedRecords;
    }
}

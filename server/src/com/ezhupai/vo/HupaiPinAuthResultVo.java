package com.ezhupai.vo;

/**
 * Created by Administrator on 2018/2/28.
 */
public class HupaiPinAuthResultVo {

    private boolean isBidingDay;
    private boolean authorized;
    private int totalAmount;
    private int leftAmount;

    public boolean getIsBidingDay() {
        return isBidingDay;
    }

    public void setBidingDay(boolean bidingDay) {
        isBidingDay = bidingDay;
    }

    public boolean getIsAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getLeftAmount() {
        return leftAmount;
    }

    public void setLeftAmount(int leftAmount) {
        this.leftAmount = leftAmount;
    }
}

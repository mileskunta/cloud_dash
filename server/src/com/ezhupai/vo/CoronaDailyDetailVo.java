package com.ezhupai.vo;

import com.ezhupai.persistence.model.CoronaDataEntity;

import javax.persistence.Column;
import java.util.Calendar;
import java.util.Date;

public class CoronaDailyDetailVo {

    private Date date;
    private int year;
    private int month;
    private int day;

    private int confirmed;
    private int suspected;
    private int cured;
    private int dead;

    public CoronaDailyDetailVo(CoronaDataEntity entity) {
        this.date = entity.getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(entity.getDate());
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DATE);

        this.confirmed = entity.getConfirmed();
        this.suspected = entity.getSuspected();
        this.cured = entity.getCured();
        this.dead = entity.getDead();
    }

    //incase there is no data for this day
    public CoronaDailyDetailVo(int x) {
        this.confirmed = 0;
        this.suspected = 0;
        this.cured = 0;
        this.dead = 0;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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
}

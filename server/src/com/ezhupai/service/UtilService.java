package com.ezhupai.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by Administrator on 2018/2/28.
 */
@Service
public class UtilService {
    private boolean isBidingDay = false;

    public void setIsBidingDay(boolean isBidingDay){
        this.isBidingDay = isBidingDay;
    }

    public boolean setIsBidingDay(){
        return this.isBidingDay;
    }

    public String getMonthStr() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH )+1;
        return year + "-" + month;
    }

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}

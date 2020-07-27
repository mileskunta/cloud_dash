package com.ezhupai.controller;

import com.ezhupai.service.UtilService;
import com.ezhupai.service.admin.AdminService;
import com.ezhupai.vo.BiddingInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/2/25.
 */
@Controller
@RequestMapping("/adminController")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UtilService utilService;

    @RequestMapping(value = "/generate-pins", method= RequestMethod.GET)
    public @ResponseBody
    List<String> authorize(@RequestParam(value = "start", required = true) int start, @RequestParam(value = "amount", required = true) int amount, HttpServletRequest request) {

        return adminService.generatePins(start,amount);
    }

    @RequestMapping(value = "/setbidding")
    public @ResponseBody
    String setBiddingDay(@RequestParam(value = "isbidingday", required = true) boolean isbidingday,
                         @RequestParam(value = "pwd", required = true) String pwd,
                         HttpServletRequest request) {
        if("haijunz".equals(pwd)){
            utilService.setIsBidingDay(isbidingday);
            return "done";
        }
        return "not authorized";
    }

    @RequestMapping(value = "/updateBiddingInfo")
    public @ResponseBody
    String setLastMonthInfo(@RequestBody BiddingInfoVo vo) {
        adminService.setBiddingInfo(vo);
        return "done";
    }

    @RequestMapping(value = "/getBiddingInfo")
    public @ResponseBody
    BiddingInfoVo getBiddingInfo() {
        return adminService.getBiddingInfo();
    }
}

package com.ezhupai.controller;

import com.ezhupai.service.FeedbackService;
import com.ezhupai.service.UtilService;
import com.ezhupai.vo.FeedbackItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/2/25.
 */
@Controller
@RequestMapping("/feedbackController")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    UtilService utilService;

    @RequestMapping(value = "/feedback", method= RequestMethod.POST)
    public @ResponseBody
    String authorize(@RequestBody FeedbackItemVo vo) {
//        try {
//            FeedbackItemVo vo = new ObjectMapper().readValue(json, FeedbackItemVo.class);
            feedbackService.saveFeedback(vo);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "done";
    }

    @RequestMapping(value = "setbidding")
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

}

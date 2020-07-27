package com.ezhupai.controller;

import com.ezhupai.service.hupaipin.AuthService;
import com.ezhupai.vo.HupaiPinAuthResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/2/25.
 */
@Controller
@RequestMapping("/authController")
public class AuthorizeController {

    @Autowired
    AuthService hupaiPinService;



    @RequestMapping(value = "/authorize")
    public @ResponseBody
    HupaiPinAuthResultVo authorize(@RequestParam(value = "pin", required = true) String pin, HttpServletRequest request) {
        return hupaiPinService.getPinAuth(pin);
    }

}

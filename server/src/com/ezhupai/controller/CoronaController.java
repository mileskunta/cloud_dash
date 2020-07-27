package com.ezhupai.controller;

import com.ezhupai.persistence.model.CoronaDataEntity;
import com.ezhupai.service.CoronaService;
import com.ezhupai.vo.CoronaDataDto;
import com.ezhupai.vo.CoronaOrgVo;
import com.ezhupai.vo.QueryCoronaDataVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/corona")
public class CoronaController {

    @Autowired
    private CoronaService service;

    @RequestMapping(value = "/all")
    public @ResponseBody
    List<CoronaDataEntity> getBiddingInfo() {
        return service.findAll();
    }



    @RequestMapping(value = "/country/province")
    public @ResponseBody
    List<CoronaDataEntity> findProvinceData(@RequestParam("country")String country,@RequestParam("province")String province) {
        return service.findProvinceData(country, province);
    }

    @RequestMapping(value = "/country/{code}")
    public @ResponseBody
    List<CoronaDataEntity> getCountryData(@PathVariable("code")String code) {
        return service.findByCountry(code);
    }

    // get latest world status
    @RequestMapping(value = "/data")
    public @ResponseBody
    List<CoronaOrgVo> getWorldwideStatus(QueryCoronaDataVo vo) {

        if(StringUtils.isNotEmpty(vo.getProvince())){
            return service.getProvinceStatus(vo.getCountry(),vo.getProvince());
        } else if(StringUtils.isNotEmpty(vo.getCountry())){
            return service.getCountryStatus(vo.getCountry());
        } else {
            return service.getWorldwideStatus();
        }
    }



    @RequestMapping(value = "/update")
    public @ResponseBody
    List<CoronaDataEntity> updateData(@RequestParam("year") int year,@RequestParam("month") int month,@RequestParam("day") int day) {
//        return service.updateCoronaData(year, Integer.parseInt(month), Integer.parseInt(day));
        return service.updateCoronaData(year, month,day);
    }


    // get world wide country trend


    //get China trend breakdown to province
    //
}

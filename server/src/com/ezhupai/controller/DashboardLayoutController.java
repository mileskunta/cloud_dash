package com.ezhupai.controller;

import com.ezhupai.persistence.model.EbayConfigEntity;
import com.ezhupai.service.DashboardLayoutService;
import com.ezhupai.vo.IdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/layout")
public class DashboardLayoutController {

    @Autowired
    DashboardLayoutService layoutService;

    @RequestMapping(value = "/all-default", method= RequestMethod.POST)
    public @ResponseBody
    List<EbayConfigEntity> loadAllDefault() {
        return layoutService.findAllDefault();
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public @ResponseBody
    EbayConfigEntity loadAllDefault(@RequestBody EbayConfigEntity entity) {
        return layoutService.saveConfig(entity);
    }

    @RequestMapping(value = "/find-by-id", method= RequestMethod.POST)
    public @ResponseBody
    EbayConfigEntity findById(@RequestBody IdVo vo) {
        return layoutService.findLayoutById(vo.getId());
    }
}

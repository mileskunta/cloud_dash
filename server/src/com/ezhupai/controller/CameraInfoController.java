package com.ezhupai.controller;

import com.ezhupai.persistence.model.CameraInfoEntity;
import com.ezhupai.service.CameraInfoService;
import com.ezhupai.service.hupaipin.AuthService;
import com.ezhupai.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/2/25.
 */
@Controller
@RequestMapping("/camera-info")
public class CameraInfoController {

    @Autowired
    CameraInfoService cameraInfoService;

    @RequestMapping(value = "/all")
    public @ResponseBody
    List<CameraInfoEntity> findAll() {
        return cameraInfoService.getAllCameraInfo();
    }

    @RequestMapping(value = "/find-by-location", method = RequestMethod.POST)
    public @ResponseBody
    CameraInfoResponseVo findCameraInfoLocationContain(@RequestBody CameraRequestVo location) {
        return cameraInfoService.findCameraInfoByLocation(location.getKeyword(), location.getStart(), location.getLimit());
    }

    @RequestMapping(value = "/find-by-position", method = RequestMethod.POST)
    public @ResponseBody
    CameraInfoResponseVo findCameraInfoPositionBetween(@RequestBody CameraRequestFrameVo vo) {
        CameraInfoResponseVo resultVo = new CameraInfoResponseVo();
        resultVo.setCameraInfoList(cameraInfoService.findCameraInfoPositionBetween(vo.getLngF(), vo.getLngT(), vo.getLatF(), vo.getLatT()));
        resultVo.setPageSize(100000);
        resultVo.setCurrentPage(1);
        resultVo.setTotalItems(resultVo.getCameraInfoList().size());
        return resultVo;
    }

    @RequestMapping(value = "/update-one")
    public @ResponseBody
    CameraInfoEntity updateOne(@RequestParam(value = "id", required = true) int id) {
        return cameraInfoService.updateGaodePosition(id);
    }

    @RequestMapping(value = "/update-data")
    public @ResponseBody
    void updateData() {
        cameraInfoService.updateGaodePositions();
    }
}

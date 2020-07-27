package com.ezhupai.service.task;

import com.ezhupai.persistence.model.CameraInfoEntity;
import com.ezhupai.service.WebRequester;
import com.ezhupai.vo.sh122.GpsInfo;
import com.ezhupai.vo.sh122.ResponseVo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("updateCameraInfoTask")
public class UpdateCameraTask {
    @Scheduled(cron = "0 0 0 0 * ?")
    public void job() {
        //execute this job every day to sync from gov site.
    }
}
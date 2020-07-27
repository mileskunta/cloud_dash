package com.ezhupai.vo;

import com.ezhupai.persistence.model.CameraInfoEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/7/14.
 */
public class CameraInfoResponseVo {
    private int totalItems;
    private int currentPage;
    private int pageSize;
    private List<CameraInfoEntity> cameraInfoList;

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<CameraInfoEntity> getCameraInfoList() {
        return cameraInfoList;
    }

    public void setCameraInfoList(List<CameraInfoEntity> cameraInfoList) {
        this.cameraInfoList = cameraInfoList;
    }
}

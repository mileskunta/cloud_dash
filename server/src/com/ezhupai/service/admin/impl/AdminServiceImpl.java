package com.ezhupai.service.admin.impl;

import com.ezhupai.persistence.dao.BiddingInfoDao;
import com.ezhupai.persistence.dao.HupaiPinHelperDao;
import com.ezhupai.persistence.model.BiddingInfoEntity;
import com.ezhupai.service.UtilService;
import com.ezhupai.service.admin.AdminService;
import com.ezhupai.vo.BiddingInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/28.
 */
@Service
@Transactional(readOnly = true, value = "transactionManager")
public class AdminServiceImpl implements AdminService {

    @Autowired
    UtilService util;

    @Autowired
    HupaiPinHelperDao hupaiPinHelperDao;

    @Autowired
    BiddingInfoDao biddingInfoDao;

    private String existingRecords;


    @Override
    public List<String> generatePins(int sequence,int amount) {

        List<String> pins = new ArrayList<String>();
        for(int i=sequence;i<amount;i++){
            pins.add(util.getRandomString(5) + i);
        }
        return pins;
    }

    @Override
    public BiddingInfoVo getBiddingInfo() {
        BiddingInfoVo vo = new BiddingInfoVo();
        List<BiddingInfoEntity> biddingInfoEntities = biddingInfoDao.findAll();

        if(!CollectionUtils.isEmpty(biddingInfoEntities)){
            BiddingInfoEntity entity = biddingInfoEntities.get(biddingInfoEntities.size()-1);
            vo.toVo(entity);
        }

        return vo;
    }

    @Override
    @Transactional(readOnly = false, value = "transactionManager")
    public void setBiddingInfo(BiddingInfoVo vo) {
        BiddingInfoEntity entity = vo.toEntity();
        this.biddingInfoDao.save(entity);
    }
}

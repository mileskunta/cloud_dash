package com.ezhupai.service;

import com.ezhupai.persistence.dao.FeedbackItemDao;
import com.ezhupai.persistence.model.FeedbackItemEntity;
import com.ezhupai.vo.FeedbackItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/6.
 */
@Service
public class FeedbackService {

    @Autowired
    FeedbackItemDao dao;

    public void saveFeedback(FeedbackItemVo vo){
        FeedbackItemEntity entity = new FeedbackItemEntity();
        entity.setCreateTime(new Date());
        entity.setTitle(vo.getTitle());
        entity.setContent(vo.getContent());
        entity.setEmail(vo.getEmail());
        entity.setCellPhone(vo.getCellPhone());

        dao.save(entity);
    }
}

package com.ezhupai.service;

import com.ezhupai.persistence.dao.DashboardLayoutDao;
import com.ezhupai.persistence.model.EbayConfigEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class DashboardLayoutService {

    @Autowired
    private DashboardLayoutDao dao;

    public List<EbayConfigEntity> findAllDefault() {
        return dao.findAllByDefaultConfig(true);
    }

    @Transactional(readOnly = false)
    public EbayConfigEntity saveConfig(EbayConfigEntity e){
        return this.dao.save(e);
    }

    public EbayConfigEntity findLayoutById(int id){
        return this.dao.findOne(id);
    }
}

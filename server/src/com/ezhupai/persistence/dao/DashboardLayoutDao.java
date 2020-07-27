package com.ezhupai.persistence.dao;

import com.ezhupai.persistence.model.BiddingInfoEntity;
import com.ezhupai.persistence.model.EbayConfigEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
@Repository
public interface DashboardLayoutDao extends CrudRepository<EbayConfigEntity, Integer> {
    EbayConfigEntity findOne(int id);

    List<EbayConfigEntity> findAll();


    List<EbayConfigEntity> findAllByDefaultConfig(boolean isDefault);


}

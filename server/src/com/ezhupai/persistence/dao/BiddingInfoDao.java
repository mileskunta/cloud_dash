package com.ezhupai.persistence.dao;

import com.ezhupai.persistence.model.BiddingInfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
@Repository
public interface BiddingInfoDao extends CrudRepository<BiddingInfoEntity, Integer> {
    BiddingInfoEntity findOne(int id);

    List<BiddingInfoEntity> findAll();
}

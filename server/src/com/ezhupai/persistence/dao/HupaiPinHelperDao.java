package com.ezhupai.persistence.dao;

import com.ezhupai.persistence.model.HupaiPinEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/2/28.
 */
@Repository
public interface HupaiPinHelperDao extends CrudRepository<HupaiPinEntity, Integer> {
    HupaiPinEntity findOne(Integer id);

    List<HupaiPinEntity> findByPinCode(String pin);



}

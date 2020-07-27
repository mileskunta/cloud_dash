package com.ezhupai.persistence.dao;

import com.ezhupai.persistence.model.FeedbackItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/2/28.
 */
@Repository
public interface FeedbackItemDao extends CrudRepository<FeedbackItemEntity, Integer> {
    FeedbackItemEntity findOne(Integer id);
}

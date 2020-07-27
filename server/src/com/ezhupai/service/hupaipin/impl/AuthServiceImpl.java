package com.ezhupai.service.hupaipin.impl;

import com.ezhupai.persistence.dao.HupaiPinHelperDao;
import com.ezhupai.persistence.model.HupaiPinEntity;
import com.ezhupai.service.UtilService;
import com.ezhupai.service.hupaipin.AuthService;
import com.ezhupai.vo.HupaiPinAuthResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/2/28.
 */
@Service
@Transactional(readOnly = true, value = "transactionManager")
public class AuthServiceImpl implements AuthService {

    @Autowired
    UtilService util;

    @Autowired
    HupaiPinHelperDao hupaiPinHelperDao;
    private String existingRecords;


    private List<HupaiPinEntity> getEntityByPinCode(String pin) {
        return hupaiPinHelperDao.findByPinCode(pin);
    }

    @Override
    @Transactional(readOnly = false, value = "transactionManager")
    public HupaiPinAuthResultVo getPinAuth(String pin) {
        HupaiPinAuthResultVo result = new HupaiPinAuthResultVo();
        List<HupaiPinEntity> entities = this.getEntityByPinCode(pin);
        if (CollectionUtils.isEmpty(entities)) {
            result.setAuthorized(false);
            result.setLeftAmount(0);
            result.setTotalAmount(0);
        } else {
            HupaiPinEntity pinEntity = entities.get(0);
            if (util.setIsBidingDay()) {
                String usedRecords = pinEntity.getUsedRecords() == null ? "" : pinEntity.getUsedRecords();
                String month = util.getMonthStr();
                if (usedRecords.indexOf(month) > -1) {
                    result.setLeftAmount(pinEntity.getLeftTimes() + 1);
                    result.setTotalAmount(pinEntity.getBuyCount());
                    result.setAuthorized(true);
                } else if (pinEntity.getLeftTimes() > 0) {
                    result.setLeftAmount(pinEntity.getLeftTimes());
                    result.setTotalAmount(pinEntity.getBuyCount());
                    result.setAuthorized(true);
                    this.useChance(pinEntity, month);
                }
            } else {
                result.setLeftAmount(pinEntity.getLeftTimes());
                result.setTotalAmount(pinEntity.getBuyCount());
                result.setAuthorized(true);
            }
        }
        return result;
    }

    private void useChance(HupaiPinEntity entity, String month) {
        entity.setLeftTimes(entity.getLeftTimes() - 1);
        String existingRecords = entity.getUsedRecords() == null ? "" : entity.getUsedRecords();
        entity.setUsedRecords(existingRecords + util.getMonthStr() + ";");
        this.hupaiPinHelperDao.save(entity);
    }
}

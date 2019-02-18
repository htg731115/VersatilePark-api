package com.hds.ssm.service.PayComboService.Impl;

import com.hds.ssm.dao.PayComboDao;
import com.hds.ssm.model.PayCombo;
import com.hds.ssm.service.PayComboService.PayComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="PayComboService")
public class PayComboServiceImpl implements PayComboService {
    @Autowired
    private PayComboDao payComboDao;
    @Override
    public PayCombo getCommonPayCombo() {
        return payComboDao.getCommonPayCombo();
    }

    @Override
    public void editCommonPayCombo() {
        payComboDao.editCommonPayCombo();
    }
}

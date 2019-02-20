package com.hds.ssm.service.PayComboService.Impl;

import com.hds.ssm.dao.PayComboDao;
import com.hds.ssm.model.PayCombo;
import com.hds.ssm.service.PayComboService.PayComboService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value="PayComboService")
public class PayComboServiceImpl implements PayComboService {
    @Autowired
    private PayComboDao payComboDao;
    @Override
    public PayCombo getCommonPayCombo() {
        return payComboDao.getCommonPayCombo();
    }

    @Override
    public void editCommonPayCombo(String combo_name, Integer effective_length, Double money) {
        payComboDao.editCommonPayCombo(combo_name,effective_length,money);
    }

    @Override
    public void insertLogPayCombo(Integer combo_id,String combo_name, Integer effective_length, Double money, Integer manage_id, Date alter_time) {
        payComboDao.insertLogPayCombo(combo_id,combo_name,effective_length,money,manage_id,alter_time);
    }

    @Override
    public List<PayCombo> getLogPayCombo(Integer combo_id) {
        return payComboDao.getLogPayCombo(combo_id);
    }
}

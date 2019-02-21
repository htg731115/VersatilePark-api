package com.hds.ssm.service.paycombo.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.dao.PayComboDao;
import com.hds.ssm.model.PayCombo;
import com.hds.ssm.model.PayComboListRQ;
import com.hds.ssm.service.paycombo.PayComboService;
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
        return payComboDao.getPayComboById(1);
    }

    @Override
    public PayCombo getDefaultPayCombo() {
        return payComboDao.getPayComboById(0);
    }

    @Override
    public void editCommonPayCombo(String combo_name, Integer effective_length, Double money) {
        payComboDao.editPayCombo(1,combo_name,effective_length,money,null,null);
    }

    @Override
    public void insertLogPayCombo(Integer combo_id,String combo_name, Integer effective_length, Double money, Integer manage_id, Date alter_time) {
        payComboDao.insertLogPayCombo(combo_id,combo_name,effective_length,money,manage_id,alter_time);
    }

    @Override
    public List<PayCombo> getLogPayCombo(Integer combo_id) {
        return payComboDao.getLogPayCombo(combo_id);
    }

    @Override
    public PageInfo<PayComboListRQ> getPayComboList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<PayComboListRQ> payComboList = payComboDao.getPaycomboList();
        PageInfo<PayComboListRQ> pageInfo = new PageInfo<>(payComboList);
        return pageInfo;
    }

    @Override
    public void deletePayCombo(Integer combo_id) {
        payComboDao.deletePayCombo(combo_id);
    }

    @Override
    public PayCombo getPayComboById(Integer combo_id) {
        return payComboDao.getPayComboById(combo_id);
    }

    @Override
    public void editPayCombo(Integer combo_id,String combo_name, Integer effective_length, Double money, Date start_time, Date end_time) {
        payComboDao.editPayCombo(combo_id,combo_name,effective_length,money, start_time, end_time);
    }
}

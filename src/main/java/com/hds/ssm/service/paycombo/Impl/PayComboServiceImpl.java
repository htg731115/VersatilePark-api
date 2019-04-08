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

    @Override
    public PageInfo<PayComboListRQ> searchComboByName(String combo_name, String project_name,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<PayComboListRQ> payComboListRQS = payComboDao.searchComboByName(combo_name, project_name);
        PageInfo<PayComboListRQ> pageInfo = new PageInfo<>(payComboListRQS);
        return pageInfo;
    }

    @Override
    public PageInfo<PayCombo> getPayComboByProjectId(Integer projectId,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<PayCombo> payComboList = payComboDao.getPayComboByProjectId(projectId);
        PageInfo<PayCombo> pageInfo = new PageInfo<>(payComboList);
        return pageInfo;
    }

    @Override
    public boolean payComboSell(Integer projectId,Integer managerId, Integer comboId) {
        if(payComboDao.canSell(projectId)!=0){
            return false; ///已經有上架套餐
        }else {
            payComboDao.sellPayCombo(managerId,comboId);
            return true;
        }
    }

    @Override
    public void payComboUnsell(Integer comboId) {
        payComboDao.unsellPayCombo(comboId);
    }

    @Override
    public PageInfo<PayCombo> managerSearchComboByName(Integer projectId, String comboName, Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<PayCombo> payComboList =  payComboDao.managerSearchComboByName(projectId,comboName);
        PageInfo pageInfo = new PageInfo<>(payComboList);
        return pageInfo;
    }

    @Override
    public void managerAddPayCombo(Integer projectId, Integer managerId, String combo_name, int effective_length, double money, Date start_time, Date end_time) {
        payComboDao.managerAddPayCombo(projectId,managerId,combo_name,effective_length,money,start_time,end_time);
    }
}

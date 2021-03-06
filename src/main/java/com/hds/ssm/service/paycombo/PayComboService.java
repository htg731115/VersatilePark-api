package com.hds.ssm.service.paycombo;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.PayCombo;
import com.hds.ssm.model.PayComboListRQ;

import java.util.Date;
import java.util.List;

public interface PayComboService {
    PayCombo getCommonPayCombo();
    PayCombo getDefaultPayCombo();
    void editCommonPayCombo(String combo_name, Integer effective_length, Double money);
    void insertLogPayCombo(Integer combo_id,String combo_name, Integer effective_length, Double money, Integer manage_id, Date alter_time);
    List<PayCombo> getLogPayCombo(Integer combo_id);
    PageInfo<PayComboListRQ> getPayComboList(Integer pageNum, Integer pageSize);
    void deletePayCombo(Integer combo_id);
    PayCombo getPayComboById(Integer combo_id);
    void editPayCombo(Integer combo_id,String combo_name, Integer effective_length, Double money, Date start_time, Date end_time);
    PageInfo<PayComboListRQ> searchComboByName(String combo_name, String project_name,Integer pageNum, Integer pageSize);
    PageInfo<PayCombo> getPayComboByProjectId(Integer projectId,Integer pageNum);
    boolean payComboSell(Integer projectId,Integer managerId, Integer comboId);

    void payComboUnsell(Integer comboId);

    PageInfo<PayCombo> managerSearchComboByName(Integer projectId, String comboName, Integer pageNum);

    void managerAddPayCombo(Integer projectId, Integer managerId, String combo_name, int effective_length, double money, Date start_time, Date end_time);

    PayCombo getSellPayCombo(Integer projectId);
}

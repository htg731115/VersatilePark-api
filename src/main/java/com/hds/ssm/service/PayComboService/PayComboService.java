package com.hds.ssm.service.PayComboService;

import com.hds.ssm.model.PayCombo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PayComboService {
    PayCombo getCommonPayCombo();
    void editCommonPayCombo(String combo_name, Integer effective_length, Double money);
    void insertLogPayCombo(Integer combo_id,String combo_name, Integer effective_length, Double money, Integer manage_id, Date alter_time);
    List<PayCombo> getLogPayCombo(Integer combo_id);
}

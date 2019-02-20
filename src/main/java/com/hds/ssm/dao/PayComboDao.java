package com.hds.ssm.dao;

import com.hds.ssm.model.PayCombo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PayComboDao {
    PayCombo getPayComboById(@Param("combo_id") Integer combo_id);
    void editPayCombo(@Param("combo_id") Integer combo_id,@Param("combo_name")String combo_name,@Param("effective_length")Integer effective_length,@Param("money")Double money);
    void insertLogPayCombo(@Param("combo_id") Integer combo_id,@Param("combo_name")String combo_name,@Param("effective_length")Integer effective_length,@Param("money")Double money,@Param("manage_id")Integer manage_id,@Param("alter_time") Date alter_time);
    List<PayCombo> getLogPayCombo(@Param("combo_id") Integer combo_id);
}

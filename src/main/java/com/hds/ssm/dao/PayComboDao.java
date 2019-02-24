package com.hds.ssm.dao;

import com.hds.ssm.model.PayCombo;
import com.hds.ssm.model.PayComboListRQ;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PayComboDao {
    PayCombo getPayComboById(@Param("combo_id") Integer combo_id);
    void editPayCombo(@Param("combo_id") Integer combo_id,@Param("combo_name")String combo_name,@Param("effective_length")Integer effective_length,@Param("money")Double money,@Param("start_time") Date start_time,@Param("end_time") Date end_time);
    void insertLogPayCombo(@Param("combo_id") Integer combo_id,@Param("combo_name")String combo_name,@Param("effective_length")Integer effective_length,@Param("money")Double money,@Param("manage_id")Integer manage_id,@Param("alter_time") Date alter_time);
    List<PayCombo> getLogPayCombo(@Param("combo_id") Integer combo_id);
    List<PayComboListRQ> getPaycomboList();
    void deletePayCombo(@Param("combo_id") Integer combo_id);
    List<PayComboListRQ> searchComboByName(@Param("combo_name") String combo_name,@Param("project_name") String project_name);
}

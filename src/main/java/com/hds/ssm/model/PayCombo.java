package com.hds.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PayCombo {

    private int combo_id;
    private int project_id;
    private int effective_length;
    private double money;
    private Date start_time;
    private Date end_time;
    private String combo_name;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private int state;
    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    private int manager_id;
    public String getCombo_name() {
        return combo_name;
    }

    public void setCombo_name(String combo_name) {
        this.combo_name = combo_name;
    }


    public int getCombo_id() {
        return combo_id;
    }

    public void setCombo_id(int combo_id) {
        this.combo_id = combo_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getEffective_length() {
        return effective_length;
    }

    public void setEffective_length(int effective_length) {
        this.effective_length = effective_length;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getAlter_time() {
        return alter_time;
    }

    public void setAlter_time(Date alter_time) {
        this.alter_time = alter_time;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH时mm分ss秒")
    public Date alter_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;
}

package com.hds.ssm.model;

import java.sql.Date;

public class ParkingRecord {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    public Date getIn_time() {
        return in_time;
    }

    public void setIn_time(Date in_time) {
        this.in_time = in_time;
    }

    public Date getOut_time() {
        return out_time;
    }

    public void setOut_time(Date out_time) {
        this.out_time = out_time;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    private Integer id;

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    private String project_name;
    private Integer del_flag;
    private Date in_time;
    private Date out_time;

    public Date getRead_in_time() {
        return read_in_time;
    }

    public void setRead_in_time(Date read_in_time) {
        this.read_in_time = read_in_time;
    }

    public Date getRead_out_time() {
        return read_out_time;
    }

    public void setRead_out_time(Date read_out_time) {
        this.read_out_time = read_out_time;
    }

    private Date read_in_time;
    private Date read_out_time;
    private String plate_number;

    public String getCombo_name() {
        return combo_name;
    }

    public void setCombo_name(String combo_name) {
        this.combo_name = combo_name;
    }

    private String combo_name;
}

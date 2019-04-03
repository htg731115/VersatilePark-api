package com.hds.ssm.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class ParkingRecordExcel {
    @Excel(name = "停车记录编号",width = 30)
    private Integer id;
    @Excel(name = "车牌号码",width = 30)
    private String plate_number;
    @Excel(name = "车辆入场时间", exportFormat = "yyyy-MM-dd",width = 30)
    private Date in_time;
    @Excel(name = "车量出场场时间",width = 30 )
    private Date out_time;

    private Date read_in_time;
    private Date read_out_time;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }





}

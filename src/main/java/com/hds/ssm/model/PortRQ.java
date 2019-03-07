package com.hds.ssm.model;

import javax.xml.crypto.Data;
import java.sql.Date;

public class PortRQ {
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

    private Date in_time;
    private Date out_time;
    private String plate_number;

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

    public int getProcessFlag() {
        return processFlag;
    }

    public void setProcessFlag(int processFlag) {
        this.processFlag = processFlag;
    }

    private int processFlag;
}

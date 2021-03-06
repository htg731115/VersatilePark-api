package com.hds.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Evaluation {
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getDegress() {
        return degress;
    }

    public void setDegress(int degress) {
        this.degress = degress;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getHandler_status() {
        return handler_status;
    }

    public void setHandler_status(int handler_status) {
        this.handler_status = handler_status;
    }

    private int customer_id;
    private int project_id;
    private int degress;

    @JsonFormat(pattern = "yyyy-MM-dd HH时mm分ss秒")
    private Date create_time;
    private int handler_status;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
}

package com.hds.ssm.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Manager {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getName() {
        return name;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    public String Project;
    public void setName(String name) {
        this.name = name;
    }
    private String name;
    private String Id_Num;

    public String getId_Num() {
        return Id_Num;
    }

    public void setId_Num(String id_Num) {
        Id_Num = id_Num;
    }

    public Date getIn_time() {
        return In_time;
    }

    public void setIn_time(Date in_time) {
        In_time = in_time;
    }

    public String getPhone_Num() {
        return Phone_Num;
    }

    public void setPhone_Num(String phone_Num) {
        Phone_Num = phone_Num;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    private Date In_time;
    private String Phone_Num;
    private int sex;

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    private String imgSrc;

}

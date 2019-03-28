package com.hds.ssm.model;

public class UserRole {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_Type() {
        return user_Type;
    }

    public void setUser_Type(Integer user_Type) {
        this.user_Type = user_Type;
    }

    Integer id;
    Integer user_Type;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    Integer projectId;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}

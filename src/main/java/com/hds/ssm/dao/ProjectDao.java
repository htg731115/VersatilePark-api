package com.hds.ssm.dao;

import com.hds.ssm.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProjectDao {
    List<Project> selectProject();
    void addProject(@Param("name")String name,
                    @Param("address")     String address,
                    @Param("opentime")Date opentime,
                    @Param("area")  int area,
                    @Param("total_num")int total_num,
                    @Param("manage_num") int manage_num,
                    @Param("state")int state,
                    @Param("admin_id") int admin_id);
}

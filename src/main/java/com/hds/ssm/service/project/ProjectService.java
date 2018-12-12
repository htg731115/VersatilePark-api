package com.hds.ssm.service.project;

import com.hds.ssm.model.Project;

import java.util.Date;
import java.util.List;

public interface ProjectService {
    List<Project> selectProject();
    void addProject(String name,
                    String address,
                    Date opentime,
                    int area,
                    int total_num,
                    int manage_num,
                    int state,
                    int admin_id);
    Project findProject(String name);
}

package com.hds.ssm.service.project;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.Project;

import java.util.Date;
import java.util.List;

public interface ProjectService {
    PageInfo<Project> selectProject(Integer pageNum,Integer pageSize);
    List<Project> getEmptyProject();
    void alterPorject(int admin_id,String project);
    void addProject(String name,
                    String address,
                    Date opentime,
                    int area,
                    int total_num,
                    int manage_num,
                    int state,
                    int admin_id);
    Project findProject(String name);
    List<Project> getAllProject();
    Project findProjectById(int id);
    Project findProjectByAdminId(int adminId);
    void editProject(Integer projectId, String name, String address, Integer area,Integer manageNum);

    void alterProject(Integer projectId, String name, String address, Integer area, Integer totalNum, boolean state);
}

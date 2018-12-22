package com.hds.ssm.service.project.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.dao.ProjectDao;
import com.hds.ssm.model.Project;
import com.hds.ssm.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value="ProjectService")
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectDao projectDao;

    @Override
    public PageInfo<Project> selectProject(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Project> userInfoList = projectDao.selectProject();
        PageInfo<Project> pageInfo = new PageInfo<>(userInfoList);
        return pageInfo;
    }

    @Override
    public void addProject(String name, String address, Date opentime, int area, int total_num, int manage_num, int state, int admin_id) {
        projectDao.addProject(name,address,opentime,area,total_num,manage_num,state,admin_id);
    }

    @Override
    public Project findProject(String name) {
        return projectDao.findProject(name);
    }

}

package com.hds.ssm.service.project.imp;

import com.hds.ssm.dao.ProjectDao;
import com.hds.ssm.model.Project;
import com.hds.ssm.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="ProjectService")
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<Project> selectProject() {
        return projectDao.selectProject();
    }
}

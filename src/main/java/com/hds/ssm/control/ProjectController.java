package com.hds.ssm.control;

import com.hds.ssm.model.Project;
import com.hds.ssm.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping(value = "/getproject")
    public List<Project> GetProject()
    {
        return projectService.selectProject();
    }

    @ResponseBody
    @RequestMapping(value = "/addproject",method = RequestMethod.POST)
    public void AddProject(@RequestBody Project project)
    {
        projectService.addProject(project.getName(),project.getAddress(),project.getOpentime(),project.getArea(),project.getTotal_num(),project.getManage_num(),project.getState(),project.getAdmin_id());
    }
}

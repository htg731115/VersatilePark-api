package com.hds.ssm.control;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.Project;
import com.hds.ssm.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping(value = "/getproject",method = RequestMethod.GET)
    public PageInfo<Project> GetProject(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize")Integer pageSize)
    {
        return projectService.selectProject(pageNum,pageSize);
    }
    @ResponseBody
    @RequestMapping(value="/getemptyproject",method = RequestMethod.GET)
    public List<Project> GetEmptyProject(){
        return projectService.getEmptyProject();
    }
    @ResponseBody
    @RequestMapping(value = "/addproject",method = RequestMethod.POST)
    public boolean AddProject(@RequestBody Project project)
    {
        String PName=project.getName();
        Project temp =projectService.findProject(PName);
        if(null==temp) {
            projectService.addProject(project.getName(), project.getAddress(), project.getOpentime(), project.getArea(), project.getTotal_num(), project.getManage_num(), project.getState(), project.getAdmin_id());
            return true;
        }
        return false;

    }
    @ResponseBody
    @RequestMapping(value = "/searchproject",method = RequestMethod.GET)
    public Project SearchProject(@RequestParam("name") String name)
    {
        Project temp =projectService.findProject(name);
        return temp;
    }

    @ResponseBody
    @RequestMapping(value = "/alterproject",method = RequestMethod.POST)
    public void AlterProject(@RequestBody Map<String,Object> map)
    {
        Integer admin_id=Integer.parseInt(map.get("admin_id").toString());
        String project=map.get("project").toString();
        projectService.alterPorject(admin_id,project);
    }
}

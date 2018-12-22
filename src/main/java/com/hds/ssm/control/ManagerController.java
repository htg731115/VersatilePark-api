package com.hds.ssm.control;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.Manager;
import com.hds.ssm.service.manage.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/api")
@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @ResponseBody
    @RequestMapping(value = "/getmanager",method = RequestMethod.GET)
    public List<Manager> GetManager()
    {
        return managerService.GetManage();
    }

    @ResponseBody
    @RequestMapping(value = "/getmanager2",method = RequestMethod.GET)//进行分页处理
    public PageInfo<Manager> GetManager2(@RequestParam("pageNum") Integer pageNum)
    {
        return managerService.GetManage2(pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/delmanager",method=RequestMethod.POST)
    public boolean DelManager (@RequestBody Map<String,Object> params) {
        Integer id = Integer.parseInt(params.get("id").toString());
        managerService.DelManager(id);
        return true;
    }
}

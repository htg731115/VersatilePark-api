package com.hds.ssm.control;

import com.hds.ssm.model.Manager;
import com.hds.ssm.service.manage.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}

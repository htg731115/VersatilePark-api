package com.hds.ssm.control;


import com.hds.ssm.model.User;
import com.hds.ssm.model.UserRole;
import com.hds.ssm.service.user.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService UserService;

    @ResponseBody
    @PostMapping("/login")
    public UserRole Login(@RequestBody User user)
    {
        User temp=UserService.findUser(user.getName());
        if(null!=temp)
        {
            if(temp.getPassword().equals(user.getPassword()))
            {
                UserRole userRole = UserService.getUserTypeById(temp.getId());
                return userRole;
            }
        }
        return null;
    }
    @ResponseBody
    @PostMapping("/addUser")
    public int addUser(@RequestBody User user){
      //暂不写  UserService.addUser("3",user.getName(),user.getPassword());
       return 1;
    }


    @ResponseBody
    @RequestMapping(value = "/all",method = RequestMethod.POST)
    public String S(@RequestBody User student)
    {
        System.out.println(student.getName());
        return UserService.selectUsers().get(0).getName();
    }
    }


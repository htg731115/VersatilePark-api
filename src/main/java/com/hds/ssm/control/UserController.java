package com.hds.ssm.control;


import com.hds.ssm.model.User;
import com.hds.ssm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService UserService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }

    @ResponseBody
    @PostMapping("/login")
    public boolean Login(@RequestBody User user)
    {
        User temp=UserService.findUser(user.getName());
        if(null!=temp)
        {
            if(temp.getPassword().equals(user.getPassword()))
                return true;
        }
        return false;
    }
    @ResponseBody
    @PostMapping("/addUser")
    public int addUser(@RequestBody User user){
        UserService.addUser("3",user.getName(),user.getPassword());
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


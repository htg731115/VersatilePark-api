package com.hds.ssm.control;


import com.hds.ssm.model.Manager;
import com.hds.ssm.model.User;
import com.hds.ssm.model.UserRole;
import com.hds.ssm.service.customer.CustomerService;
import com.hds.ssm.service.manage.ManagerService;
import com.hds.ssm.service.project.ProjectService;
import com.hds.ssm.service.user.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService UserService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private CustomerService customerService;
    @ResponseBody
    @PostMapping("/login")
    public UserRole Login(@RequestBody User user,HttpSession session)
    {
        User temp=UserService.findUser(user.getName());
        if(null!=temp)
        {
            if(temp.getPassword().equals(user.getPassword()))
            {
                UserRole userRole = UserService.getUserTypeById(temp.getId());
                if(userRole.getUser_Type()==1)//该用户为项目管理员
                {
                    Integer projectId =  projectService.findProjectByAdminId(userRole.getId()).getId();
                    userRole.setProjectId(projectId);
                    session.setAttribute("userId",temp.getId());
                    session.setAttribute("projectId",projectId);
                    session.setAttribute("userName",userRole.getName());
                }
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
    @ResponseBody
    @RequestMapping(value = "/update-manager-password",method = RequestMethod.POST)
    public boolean changePassWord(@RequestParam("id")String id,@RequestParam("oldPassWord")String oldPassWord,@RequestParam("passWord")String passWord){
        User user = UserService.findUserById(Integer.parseInt(id));
        if (user.getPassword().equals(oldPassWord)){
            UserService.changePassWord(Integer.parseInt(id),passWord);
            return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping(value = "/can-register",method = RequestMethod.GET)
    public boolean canRegister(@RequestParam("phone") String phone){
        return managerService.canRegister(phone);
    }
    @ResponseBody
    @RequestMapping(value = "/can-register2",method = RequestMethod.GET)
    public boolean canRegister2(@RequestParam("name") String name){
        User user = UserService.findUser(name);
        if(null!=user){
            return false;
        }
        return true;
    }
    @ResponseBody
    @RequestMapping(value = "/add-customer",method = RequestMethod.POST)
    public void addCustomer(@RequestParam("phone") String phone,@RequestParam("name") String name,@RequestParam("username")String username,
                                @RequestParam("password")String password,@RequestParam("sex")String sex, @RequestParam(value = "idnumber")String idnumber){
       User user = new User();
       user.setName(name);
       user.setPassword(password);
       user.setUser_name(username);
       UserService.addUser(user);
       customerService.addCustomer(user.getId(),username,phone,sex,idnumber);
    }

    @ResponseBody
    @RequestMapping(value = "/user-login",method = RequestMethod.POST)
    public void userLogin(HttpSession session){
        session.setAttribute("customerId",11);
    }

    @ResponseBody
    @RequestMapping(value = "/addManager",method = RequestMethod.POST)
    public Integer addManager(String name,String userName,String password,String idNum,String phoneNum,String sex){
        User user = UserService.findUser(name);
        if(null !=user){
            return 1;//用户名重复
        }
        else{
            User user1 = new User();
            user1.setName(name);
            user1.setPassword(password);
            user1.setUser_name(userName);
            Manager manager = new Manager();
            manager.setId_Num(idNum);
            manager.setPhone_Num(phoneNum);
            manager.setName(userName);
            manager.setSex(Integer.parseInt(sex));
            UserService.addUser(user1);
            int id = user1.getId();
            manager.setId(id);
            managerService.addManager(manager);
            return 2;
        }
    }

//    @RequestMapping
//    @RequestMapping(value = "/add-customer",method = RequestMethod.POST)
//    public boolean addCustomer(@RequestParam("phone")String phone, @RequestParam("name")String name, @RequestParam("password")String password)

 }


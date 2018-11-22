package com.hds.ssm.service.user.imp;


import com.hds.ssm.dao.UserDao;
import com.hds.ssm.model.User;
import com.hds.ssm.service.user.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响

    public void addUser(String id,String name,String password) {
         userDao.addUser(id,name,password);
    }
    public List<User> selectUsers(){
        return userDao.selectUsers();
    }

    @Override
    public User findUser(String name) {
        return userDao.findUser(name);
    }
}


package com.hds.ssm.service.user.imp;


import com.hds.ssm.dao.UserDao;
import com.hds.ssm.model.User;
import com.hds.ssm.model.UserRole;
import com.hds.ssm.service.user.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;//这里会报错，但是并不会影响

    public int addUser(User user) {
         return userDao.addUser(user);
    }

    @Override
    public UserRole getUserTypeById(Integer id) {
        return userDao.getUserTypeById(id);
    }

    @Override
    public void changePassWord(Integer id, String password) {
        userDao.changePassWord(id,password);
    }

    public List<User> selectUsers(){
        return userDao.selectUsers();
    }

    @Override
    public User findUser(String name) {
        return userDao.findUser(name);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }
}


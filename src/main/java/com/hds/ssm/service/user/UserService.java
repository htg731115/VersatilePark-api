package com.hds.ssm.service.user;



import com.hds.ssm.model.User;
import com.hds.ssm.model.UserRole;

import java.util.List;

public interface UserService {

    List<User> selectUsers();
    User findUser(String name);
    User findUserById(Integer id);
    void addUser(String id,String name,String password);
    UserRole getUserTypeById(Integer id);
    void changePassWord(Integer id, String password);
}

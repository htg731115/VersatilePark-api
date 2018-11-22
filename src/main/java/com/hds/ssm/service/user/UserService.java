package com.hds.ssm.service.user;



import com.hds.ssm.model.User;

import java.util.List;

public interface UserService {

    List<User> selectUsers();
    User findUser(String name);
    void addUser(String id,String name,String password);
}

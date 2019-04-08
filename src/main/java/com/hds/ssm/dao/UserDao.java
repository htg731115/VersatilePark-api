package com.hds.ssm.dao;




import com.hds.ssm.model.User;
import com.hds.ssm.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int insert(User record) ;
    List<User> selectUsers();
    User findUser(@Param("name")String name);
    User findUserById(@Param("id") Integer id);
    int addUser(User user);
    UserRole getUserTypeById(@Param("id") Integer id);
    void changePassWord(@Param("id")Integer id,@Param("password") String password);

}

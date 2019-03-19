package com.hds.ssm.dao;




import com.hds.ssm.model.User;
import com.hds.ssm.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int insert(User record) ;
    List<User> selectUsers();
    User findUser(@Param("name")String name);
    void addUser(@Param("id") String id,@Param("name")String name,@Param("password")String password);
    UserRole getUserTypeById(@Param("id") Integer id);
}

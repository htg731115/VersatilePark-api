package com.hds.ssm.dao;

import com.hds.ssm.model.Manager;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerDao {
    List<Manager> GetManager();
    List<Manager> GetManager2();
    Manager FindManager(@Param("id")int id);
    void DelManager(@Param("id")Integer id);
    Manager GetDetails(@Param("id") Integer id);
    void editManagerInfo(@Param("id") Integer id,@Param("name")String name, @Param("idNum")String idNum, @Param("phoneNum") String phoneNum);

    void updateManagerImg(@Param("imgSrc") String imgSrc,@Param("id") String managerId);

    int canRegister(@Param("phone") String phone);

    void addManager(@Param("id")Integer id,@Param("name") String name, @Param("sex") int sex,@Param("idNum") String id_num,@Param("phoneNum") String phone_num);
}

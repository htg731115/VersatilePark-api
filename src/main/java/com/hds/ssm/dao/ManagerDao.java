package com.hds.ssm.dao;

import com.hds.ssm.model.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerDao {
    List<Manager> GetManager();
    Manager FindManager(@Param("id")int id);
}

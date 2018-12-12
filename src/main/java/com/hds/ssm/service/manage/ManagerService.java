package com.hds.ssm.service.manage;

import com.hds.ssm.model.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> GetManage();
    Manager FindManage(int id);
}

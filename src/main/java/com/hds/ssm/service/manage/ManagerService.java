package com.hds.ssm.service.manage;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> GetManage();
    PageInfo<Manager> GetManage2(Integer pageNum);
    Manager FindManage(int id);
    void DelManager(Integer id) ;
    void editManagerInfo(Integer id ,String name,String idNum,String phoneNum);

    void updateManagerImg(String imgSrc, String managerId);

    boolean canRegister(String phone);
}

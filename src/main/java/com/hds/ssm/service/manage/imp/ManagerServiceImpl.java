package com.hds.ssm.service.manage.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.dao.ManagerDao;
import com.hds.ssm.model.Manager;
import com.hds.ssm.service.manage.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="ManagerService")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public List<Manager> GetManage() {
        return managerDao.GetManager();
    }

    @Override
    public PageInfo<Manager> GetManage2(Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<Manager>ManagerList=managerDao.GetManager2();
        PageInfo<Manager> pageInfo =new PageInfo<>(ManagerList);
        return pageInfo;
    }

    @Override
    public Manager FindManage(int id) {
        return managerDao.FindManager(id);
    }

    @Override
    public void DelManager(Integer id) {
         managerDao.DelManager(id);
    }

    @Override
    public void editManagerInfo(Integer id, String name, String idNum, String phoneNum) {
        managerDao.editManagerInfo(id,name,idNum,phoneNum);
    }

    @Override
    public void updateManagerImg(String imgSrc, String managerId) {
        managerDao.updateManagerImg(imgSrc,managerId);
    }

    @Override
    public boolean canRegister(String phone) {
        int count = managerDao.canRegister(phone);
        if(count == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void addManager(Manager manager) {
        managerDao.addManager(manager.getId(),manager.getName(),manager.getSex(),manager.getId_Num(),manager.getPhone_Num());
    }
}

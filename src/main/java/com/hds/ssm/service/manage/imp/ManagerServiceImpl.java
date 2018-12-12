package com.hds.ssm.service.manage.imp;

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
}

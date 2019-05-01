package com.hds.ssm.service.customer.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.dao.CustomerDao;
import com.hds.ssm.model.Customer;
import com.hds.ssm.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value="CustomerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Override
    public PageInfo<Customer> GetCustomer(int pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Customer> customers =customerDao.GetCustomer();
        PageInfo<Customer> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public PageInfo<Customer> GetCertCustomer(int pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Customer>customers=customerDao.GetCertCustomer();
        PageInfo<Customer> pageInfo=new PageInfo<>(customers);
        return pageInfo;
    }

    @Override
    public Integer GetTotal() {
        return customerDao.GetTotal();
    }

    @Override
    public Integer GetCertNum() {
        return customerDao.GetCertNum();
    }

    @Override
    public void addCustomer(int useId, String username, String phone, String sex, String idnumber) {
         customerDao.addCustomer(useId,username,phone,sex,idnumber);
    }

    @Override
    public Customer findCustomer(Integer userId) {
        return customerDao.findCustomer(userId);
    }

    @Override
    public void commitCert(String idNumber, Integer userId, String imgSrc, String projectId, String state) {
        customerDao.commitCert(idNumber,userId,imgSrc,projectId,state);

    }


}

package com.hds.ssm.service.customer;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.Customer;

import java.util.Map;

public interface CustomerService {
    PageInfo<Customer> GetCustomer(int pageNum);
    PageInfo<Customer>GetCertCustomer(int pageNum);
    Integer GetTotal();
    Integer GetCertNum();

    void addCustomer(int useId, String username, String phone, String sex, String idnumber);

    Customer findCustomer(Integer userId);

    void commitCert(String idNumber, Integer userId, String imgSrc,String projectId,String state,String plateNumber);

    Map adjustCert(Integer userId);
}

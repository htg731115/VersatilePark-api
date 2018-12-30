package com.hds.ssm.service.customer;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.Customer;

public interface CustomerService {
    PageInfo<Customer> GetCustomer(int pageNum);
    PageInfo<Customer>GetCertCustomer(int pageNum);
    Integer GetTotal();
    Integer GetCertNum();
}

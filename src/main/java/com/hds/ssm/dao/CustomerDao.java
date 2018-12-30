package com.hds.ssm.dao;

import com.hds.ssm.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {
    List<Customer> GetCustomer();
    List<Customer>GetCertCustomer();
    Integer GetTotal();
    Integer GetCertNum();

}

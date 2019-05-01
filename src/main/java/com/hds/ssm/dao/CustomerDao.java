package com.hds.ssm.dao;

import com.hds.ssm.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {
    List<Customer> GetCustomer();
    List<Customer>GetCertCustomer();
    Integer GetTotal();
    Integer GetCertNum();

    void addCustomer(@Param("useId") int useId,@Param("username") String username, @Param("phone") String phone, @Param("sex") String sex,@Param("idnumber") String idnumber);

    Customer findCustomer(@Param("userId")Integer userId);

    void commitCert(@Param("idNumber") String idNumber, @Param("userId") Integer userId, @Param("state") String state,@Param("projectId") String projectId, @Param("imgSrc") String imgSrc);
}

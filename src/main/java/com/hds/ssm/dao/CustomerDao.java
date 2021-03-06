package com.hds.ssm.dao;

import com.hds.ssm.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerDao {
    List<Customer> GetCustomer();
    List<Customer>GetCertCustomer();
    Integer GetTotal();
    Integer GetCertNum();

    void addCustomer(@Param("useId") int useId,@Param("username") String username, @Param("phone") String phone, @Param("sex") String sex,@Param("idnumber") String idnumber);

    Customer findCustomer(@Param("userId")Integer userId);

    void commitCert( @Param("customer_id") Integer userId,@Param("imgSrc") String imgSrc, @Param("projectId") String projectId, @Param("state") String state);

    void customerCertChange(@Param("customer_id") Integer userId,@Param("idNumber") String idNumber,@Param("projectId") String projectId,@Param("plateNumber") String plateNumber);

    Map adjustCert(@Param("customer_id") Integer userId);

    void commitEvaluation(@Param("customer_id") Integer userId,@Param("projectId")  String projectId,@Param("degress")  Integer degress,@Param("content")  String content);

    void alterCustomer(@Param("customer_id") Integer customerId,@Param("phone")  String phone, @Param("plateNum") String plateNum,
                       @Param("idnumber") String idnumber,@Param("sex")  Integer sex);

    List<Customer> searchCustomerByName(@Param("name") String name);
}

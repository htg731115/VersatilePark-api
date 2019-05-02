package com.hds.ssm.control;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.Customer;
import com.hds.ssm.model.User;
import com.hds.ssm.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/api")
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/getcustomer",method = RequestMethod.GET)
    public PageInfo<Customer> GetCustomer(@RequestParam("pageNum") int pageNum)
    {
        return    customerService.GetCustomer(pageNum);
    }
    @ResponseBody
    @RequestMapping(value = "/getcertcustomer",method = RequestMethod.GET)
    public PageInfo<Customer>GetCertCustomer(@RequestParam("pageNum") int pageNum)
    {
        return customerService.GetCertCustomer(pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/gettotal",method = RequestMethod.GET)
    public Integer GetTotal()
    {
        return customerService.GetTotal();
    }
    @ResponseBody
    @RequestMapping(value = "/getcertnum",method = RequestMethod.GET)
    public Integer GetCertNum()
    {
        return customerService.GetCertNum();
    }

    @ResponseBody
    @RequestMapping(value = "/user-get-phone-name",method = RequestMethod.GET)
    public Customer userGetPhoneName(HttpSession session){
        Integer userId = Integer.parseInt(session.getAttribute("customerId").toString());
        return customerService.findCustomer(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/commitCert",method = RequestMethod.POST)
    public void commitCert(String idNumber,String imgSrc,String projectId,String plateNumber,HttpSession session){
        String state ="0";
        Integer userId = Integer.parseInt(session.getAttribute("customerId").toString());
        customerService.commitCert(idNumber,userId,imgSrc,projectId,state,plateNumber);

    }

    @ResponseBody
    @RequestMapping(value = "/adjust-cert",method = RequestMethod.GET)
    public Map adjustCert(HttpSession session){
        Integer userId = Integer.parseInt(session.getAttribute("customerId").toString());
        Map status = customerService.adjustCert(userId);
        return status;
    }
}

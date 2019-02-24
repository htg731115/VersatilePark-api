package com.hds.ssm.control;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.PayCombo;
import com.hds.ssm.model.PayComboListRQ;
import com.hds.ssm.service.paycombo.PayComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RequestMapping("/api")
@Controller
public class PayComboController {
    @Autowired
    PayComboService payComboService;

    @ResponseBody
    @RequestMapping(value = "/getcompaycombo",method = RequestMethod.GET)
    public PayCombo getCommonPayCombo(){
        PayCombo commonPayCombo = payComboService.getCommonPayCombo();
        return commonPayCombo;
    }

    @ResponseBody
    @RequestMapping(value = "/editcompaycombo",method = RequestMethod.POST)
    public void editComPayCombo(@RequestBody PayCombo payCombo)
    {
        PayCombo logCombo=payComboService.getCommonPayCombo();
        payComboService.insertLogPayCombo(1,logCombo.getCombo_name(),logCombo.getEffective_length(),logCombo.getMoney(),1,new Date());
        payComboService.editCommonPayCombo(payCombo.getCombo_name(),payCombo.getEffective_length(),payCombo.getMoney());
    }

    @ResponseBody
    @RequestMapping(value = "/edit-paycombo", method = RequestMethod.POST)
    public void editPayCombo(@RequestBody PayCombo payCombo){
        PayCombo logCombo = payComboService.getPayComboById(payCombo.getCombo_id());
        payComboService.insertLogPayCombo(logCombo.getCombo_id(),logCombo.getCombo_name(),logCombo.getEffective_length(),logCombo.getMoney(),logCombo.getManager_id(),new Date());
        payComboService.editPayCombo(payCombo.getCombo_id(),payCombo.getCombo_name(),payCombo.getEffective_length(),payCombo.getMoney(),payCombo.getStart_time(), payCombo.getEnd_time());
    }

    @ResponseBody
    @RequestMapping(value = "/get-log-paycombo",method = RequestMethod.GET)
    public List<PayCombo> getLogPayCombo(@RequestParam("combo_id") Integer combo_id){
        List <PayCombo> logPayCombo = payComboService.getLogPayCombo(combo_id);
        return logPayCombo;
    }

    @ResponseBody
    @RequestMapping(value = "/get-default-paycombo",method = RequestMethod.GET)
    public PayCombo getDefaultPayCombo(){
        return payComboService.getDefaultPayCombo();
    }

    @ResponseBody
    @RequestMapping(value = "/get-paycomboList",method = RequestMethod.GET)
    public PageInfo<PayComboListRQ> getPayComboList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        return payComboService.getPayComboList(pageNum, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/delete-paycombo", method = RequestMethod.POST)
    public void deletePayCombo(@RequestParam("combo_id") Integer combo_id){
         payComboService.deletePayCombo(combo_id);
    }

    @ResponseBody
    @RequestMapping(value = "/search-combo-byName", method = RequestMethod.GET)
    public PageInfo<PayComboListRQ> searchComboByName(@RequestParam("combo_name") String combo_name,@RequestParam("project_name") String project_name,
                                                      @RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        return payComboService.searchComboByName(combo_name,project_name,pageNum,pageSize);
    }
}

package com.hds.ssm.control;

import com.hds.ssm.model.PayCombo;
import com.hds.ssm.service.PayComboService.PayComboService;
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
        payComboService.insertLogPayCombo(0,logCombo.getCombo_name(),logCombo.getEffective_length(),logCombo.getMoney(),1,new Date());
        payComboService.editCommonPayCombo(payCombo.getCombo_name(),payCombo.getEffective_length(),payCombo.getMoney());
    }

    @ResponseBody
    @RequestMapping(value = "/get-log-paycombo",method = RequestMethod.GET)
    public List<PayCombo> getLogPayCombo(@RequestParam("combo_id") Integer combo_id){
        List <PayCombo> logPayCombo = payComboService.getLogPayCombo(combo_id);
        return logPayCombo;
    }
}

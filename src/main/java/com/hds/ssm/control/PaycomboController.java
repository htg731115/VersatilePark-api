package com.hds.ssm.control;

import com.hds.ssm.model.PayCombo;
import com.hds.ssm.service.PayComboService.PayComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api")
@Controller
public class PaycomboController {
    @Autowired
    PayComboService payComboService;

    @ResponseBody
    @RequestMapping(value = "getcompaycombo",method = RequestMethod.GET)
    public PayCombo getCommonPayCombo(){
        PayCombo commonPayCombo = payComboService.getCommonPayCombo();
        return commonPayCombo;
    }

    @ResponseBody
    @RequestMapping(value = "editcompaycombo",method = RequestMethod.POST)
    public void editComPayCombo(PayCombo payCombo)
    {

    }
}

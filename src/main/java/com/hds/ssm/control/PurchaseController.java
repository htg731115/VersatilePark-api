package com.hds.ssm.control;

import com.hds.ssm.model.PurchaseRP;
import com.hds.ssm.service.purchase.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/api")
@Controller
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @ResponseBody
    @RequestMapping(value = "/purchase-month",method = RequestMethod.GET)
    public Map<String,Integer> getPurchaseMonth(){
        List<PurchaseRP> purchaseRPS=purchaseService.getPurchaseMonth();
        Map<String,Integer> re = new HashMap<>();
        int index=0;
        for(Integer i =0; i<12;i++){
            if(index<purchaseRPS.size()&&(i+1)==purchaseRPS.get(index).getMonth()){
                re.put(i.toString(),purchaseRPS.get(index).getPurchaseCount());
                index++;
            }else{
                re.put(i.toString(),0);
            }
        }
        return re;
    }
}

package com.hds.ssm.control;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.PayCombo;
import com.hds.ssm.model.PayComboListRQ;
import com.hds.ssm.service.paycombo.PayComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @ResponseBody
    @RequestMapping(value = "/manager-get-payCombo",method = RequestMethod.GET)
    public PageInfo<PayCombo> managerGetPayCombo(HttpSession session,@RequestParam("pageNum")Integer pageNum){
        Integer projectId = Integer.parseInt(session.getAttribute("projectId").toString());
        return payComboService.getPayComboByProjectId(projectId,pageNum);
    }

    @ResponseBody
    @RequestMapping(value = "/manager-search-payCombo",method = RequestMethod.GET)
    public PageInfo<PayCombo> managerSearchPayCombo(HttpSession session,@RequestParam("pageNum")Integer pageNum,@RequestParam("comboName") String comboName){
        Integer projectId = Integer.parseInt(session.getAttribute("projectId").toString());
        return payComboService.managerSearchComboByName(projectId,comboName,pageNum);
    }

    //管理员添加临时套餐 没有上架的

    @ResponseBody
    @RequestMapping(value = "/manager-add-payCombo",method = RequestMethod.POST)
    public void managerAddPayCombo(HttpSession session,@RequestBody PayCombo payCombo){
        Integer projectId = Integer.parseInt(session.getAttribute("projectId").toString());
        Integer managerId = Integer.parseInt(session.getAttribute("userId").toString());
        payComboService.managerAddPayCombo(projectId,managerId,payCombo.getCombo_name(),payCombo.getEffective_length(),payCombo.getMoney(),payCombo.getStart_time(),payCombo.getEnd_time());
    }

//    套餐上架
    @ResponseBody
    @RequestMapping(value = "/paycombo-sell",method = RequestMethod.POST)
    public boolean payComboSell(HttpSession session, @RequestParam("comboId") Integer comboId){
        Integer managerId = Integer.parseInt(session.getAttribute("userId").toString());
        Integer projectId = Integer.parseInt(session.getAttribute("projectId").toString());
        return payComboService.payComboSell(projectId,managerId,comboId);
    }

//    套餐下架
    @ResponseBody
    @RequestMapping(value = "/paycombo-unsell",method = RequestMethod.POST)
    public void payComboUnsell(@RequestParam("comboId") Integer comboId){
        payComboService.payComboUnsell(comboId);
    }
//    @ResponseBody
//    @RequestMapping(value = "/get-logCombo", method = RequestMethod.GET)
//    public PageInfo<PayComboListRQ> getLogCombo(@RequestParam("combo_name") String comboName, @RequestParam("project_name") String projectName){
//        return payComboService.getLogPayCombo()
//    }
}

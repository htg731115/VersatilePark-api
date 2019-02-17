package com.hds.ssm.control;

import com.github.pagehelper.PageInfo;
import com.hds.ssm.model.Evaluation;

import com.hds.ssm.service.evaluation.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RequestMapping("/api")
@Controller

public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @ResponseBody
    @RequestMapping(value = "/getEvaluationNum",method = RequestMethod.GET)
    public Map<String,Integer> getEvaluationNum(){
        Map<String, Integer> evalNumMap = new HashMap<>();
        Integer goodEval = evaluationService.getGoodEval();
        Integer middleEval = evaluationService.getMiddleEval();
        Integer badEval = evaluationService.getBadEval();
        evalNumMap.put("good",goodEval);
        evalNumMap.put("middle",middleEval);
        evalNumMap.put("bad",badEval);
        return evalNumMap;
    }
    @ResponseBody
    @RequestMapping(value="/getEvalList",method = RequestMethod.GET)
    public PageInfo<Evaluation>GetCertCustomer(@RequestParam("type") String type){
        if("好评".equals(type)){
            return evaluationService.getGoodEvalList(1);
        }
        return evaluationService.getAll();
    }
    @ResponseBody
    @RequestMapping(value="/getEvalList2",method = RequestMethod.GET)
    public PageInfo<Evaluation>getEvalList(@RequestParam("pageNum") Integer pageNum, @RequestParam("type") String type){
        if("好评".equals(type)){
            return evaluationService.getGoodEvalList(pageNum);
        }else if("中评".equals(type)){
            return evaluationService.getMiddleEvalList(pageNum);
        }else if("差评".equals(type)){
            return evaluationService.getBadEvalList(pageNum);
        }else{
            return evaluationService.getAllEvalList(pageNum);
        }
    }
}

package com.hds.ssm.control;

import com.baidu.aip.ocr.AipOcr;
import com.hds.ssm.service.apiOcr.apiOcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiOcrController {
    @Autowired
    apiOcrService apiOcrService;
    final  String pic_path = "D:\\VersatilePark-api\\target\\";
    @ResponseBody
    @RequestMapping("/helloWorld")
    public String m(){
        return apiOcrService.ocrPlateNumber("1");
    }

    @ResponseBody
    @RequestMapping(value = "/ocr-platenumber",method = RequestMethod.GET)
    public String ocrPlateNumber(@RequestParam("imgSrc") String imgSrc){
        return apiOcrService.ocrPlateNumber(pic_path+imgSrc);
    }
}

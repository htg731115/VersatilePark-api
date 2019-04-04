package com.hds.ssm.control;

import com.baidu.aip.ocr.AipOcr;
import com.hds.ssm.service.apiOcr.apiOcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiOcrController {
    @Autowired
    apiOcrService apiOcrService;
    @ResponseBody
    @RequestMapping("/helloWorld")
    public void m(){
        apiOcrService.ocrPlateNumber();
    }
}

package com.hds.ssm.control;

import com.baidu.aip.ocr.AipOcr;
import com.hds.ssm.service.apiOcr.apiOcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class ApiOcrController {
    @Autowired
    apiOcrService apiOcrService;
    final  String pic_path = "D:\\VersatilePark-api\\target\\";

    @ResponseBody
    @RequestMapping(value = "/ocr-platenumber",method = RequestMethod.GET)
    public String ocrPlateNumber(@RequestParam("imgSrc") String imgSrc){
        return apiOcrService.ocrPlateNumber(pic_path+imgSrc);
    }

    @ResponseBody
    @RequestMapping(value = "/ocr-idnumber",method = RequestMethod.POST)
    public String managerUploadImg(MultipartFile file, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String pic_path = "D:\\VersatilePark-api\\target\\idNumber\\";
        String filename = file.getOriginalFilename();
            //上传图片
            if(file!=null && filename!=null && filename.length()>0) {
                //新的图片名称
                String newFileName = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
                //新图片
                File newFile = new File(pic_path + newFileName);
                //将内存中的数据写入磁盘
                file.transferTo(newFile);
                return apiOcrService.ocrIdNumber(newFile.getAbsolutePath());
            }
        return "bad";
    }
}

package com.hds.ssm.control;

import com.hds.ssm.service.manage.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RequestMapping("/api")
@Controller
public class FileController {
    @Autowired
        ManagerService managerService;
    @ResponseBody
    @RequestMapping("/manager-upload-img")
    public void managerUploadImg(MultipartFile file, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String managerId  = session.getAttribute("userId").toString();
        //获取文件原始名称
        String filename = file.getOriginalFilename();
        //上传图片
        if(file!=null && filename!=null && filename.length()>0){
            //存储图片的物理路径
            String pic_path = "D:\\VersatilePark-api\\target\\img\\";
            //新的图片名称
            String newFileName = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
            //新图片
            File newFile = new File(pic_path+newFileName);
            //将内存中的数据写入磁盘
            file.transferTo(newFile);
            managerService.updateManagerImg("http://localhost:8090/img/"+newFileName,managerId);
        }
    }
}

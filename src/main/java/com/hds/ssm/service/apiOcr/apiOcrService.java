package com.hds.ssm.service.apiOcr;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

@Service("apiOcrService")
public class apiOcrService {
    public static final String APP_ID = "15917827";
    public static final String API_KEY = "xBXxtdoIPDrjboqGCGh2yuzL";
    public static final String SECRET_KEY = "CiSfSA57oisGFGQjxsuVqWMA5ueIGihl";
    AipOcr client;
    private apiOcrService()  {
        client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

    }
    public void ocrPlateNumber(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("multi_detect", "true");


        // 参数为本地路径
        String image = "C:\\Users\\mu\\Desktop\\2.png";
        JSONObject res = client.plateLicense(image, options);
        System.out.println(res.toString(2));

    }

}

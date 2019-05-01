package com.hds.ssm.service.apiOcr;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONException;
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
    public String ocrPlateNumber(String image){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("multi_detect", "true");


        // 参数为本地路径
        JSONObject res = client.plateLicense(image, options);
        try {
            JSONArray data = res.getJSONArray("words_result");
            String plateNumber = data.getJSONObject(0).getString("number");
            return plateNumber;
        }catch (JSONException e){
            return "bad";
        }
    }
    public String ocrIdNumber(String image){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");
        options.put("id_card_side", "front");
        String idCardSide = "back";

        // 参数为本地路径
        JSONObject res = client.idcard(image, idCardSide, options);
            System.out.println(res.toString(2));
        try {
            JSONObject data = res.getJSONObject("words_result");
            String idNumber = data.getJSONObject("公民身份号码").getString("words");
            if(idNumber.equals("")){
                return "bad";
            }
            return idNumber;
        }catch(JSONException e){
            return "bad";
        }
    }

}

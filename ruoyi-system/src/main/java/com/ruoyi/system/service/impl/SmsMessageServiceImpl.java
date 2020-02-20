package com.ruoyi.system.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ruoyi.common.mms.DateeTimeUtils;
import com.ruoyi.common.mms.Md5Baes64Utils;
import com.ruoyi.system.mms.PublPojo;
import com.ruoyi.system.service.SmsMessageService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hmbfe
 * @version：
 * @date 2020-02-20 18:38
 * @description：1.1获取token接口
 */
public class SmsMessageServiceImpl implements SmsMessageService {

    @Override
    public String tokenSms(String username, String password) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://ip:prot/api/v1/user/token";
        PublPojo requestPojo = new PublPojo();
        PublPojo responsePojo = new PublPojo();
        requestPojo.setId(null);        //id为null
        responsePojo.setId(null);        //id为null
        Map<String, String> requestcontent = new HashMap<String, String>();
        requestcontent.put("username", username);
        requestcontent.put("password", password);
        requestPojo.setContent(requestcontent);    //content
        responsePojo.setContent(requestcontent);    //content
        Map<String, String> requestoption = new HashMap<String, String>();
        // 时间戳
        long currentTimeMillis = DateeTimeUtils.getTime();
        String reqTime = String.valueOf(currentTimeMillis);
        requestoption.put("reqtime", reqTime);
        requestPojo.setOption(requestoption);        //option
        responsePojo.setOption(requestoption);        //option
        String signJson = gson.toJson(requestPojo);
        String mdBase64 = Md5Baes64Utils.mdBase64(signJson);
        responsePojo.setSign(mdBase64);
        String requestjson = gson.toJson(responsePojo);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> bodyEntity = new HttpEntity<>(requestjson, headers);
        String postForObject = restTemplate.postForObject(url, bodyEntity, String.class);
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(postForObject);
        String responseCode = jsonObject.get("content").getAsJsonObject().get("code").getAsString();
        String responseMessage = jsonObject.get("content").getAsJsonObject().get("message").getAsString();
        String responseToken = jsonObject.get("content").getAsJsonObject().get("result").getAsJsonObject().get("token").getAsString();
        /*User user = new User();
        user.setMmsUsername(username);
        user.setMmsPassword(password);
        user.setCode(responseCode);
        user.setMessage(responseMessage);
        user.setMmsToken(responseToken);
        user.setReqTime(reqTime);
        int insertUser = userService.insertUser(user);
        if (insertUser==1) {
            return responseToken;
        }else {
            return "数据库存取错误";		//待改
        }*/
        return responseToken;
    }
}

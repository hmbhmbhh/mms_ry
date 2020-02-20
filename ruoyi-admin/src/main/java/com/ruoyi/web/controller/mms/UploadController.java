package com.ruoyi.web.controller.mms;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.service.SmsMessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hmbfe
 * @version：
 * @date 2020-02-20 18:29
 * @description：
 */
@Controller
public class UploadController extends BaseController {
    @Autowired
    private SmsMessageService smsMessageService;
    /**
     *
     * @Description: 1.1获取token接口
     * @return String 返回类型
     *
     *         用来获取token username：卓望提供的用户名 password：卓望提供的密码
     */
    @PostMapping(value = "/token")
    @ResponseBody
    @ApiOperation("1.1获取token接口")
    public String tokenSms(@RequestParam("username") String username, @RequestParam("password") String password) {
//		Gson gson = new GsonBuilder().serializeNulls().create();
        String tokenSms = smsMessageService.tokenSms(username, password);
//		String json = gson.toJson(tokenSms);
        return tokenSms;
    }
}

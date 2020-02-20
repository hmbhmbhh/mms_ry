package com.ruoyi.system.service;

/**
 * @author hmbfe
 * @version：
 * @date 2020-02-20 18:36
 * @description：
 */
public interface SmsMessageService {
    /**
     *
     * @Description:  1.1获取token接口
     * @return UnifyPojo    返回类型
     */
    public String tokenSms(String username,String password);
}

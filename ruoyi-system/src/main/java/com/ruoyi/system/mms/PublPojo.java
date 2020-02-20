package com.ruoyi.system.mms;


import lombok.Data;

import java.util.Map;

/**
 * @author hmbfe
 * @version：
 * @date 2020-02-20 15:48
 * @description：统一待加密基类
 */
@Data
public class PublPojo {
    private Map<String, String> id;
    private Map<String, String> content;
    private Map<String, String> option;
    private String sign;
}

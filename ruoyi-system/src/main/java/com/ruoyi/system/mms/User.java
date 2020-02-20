package com.ruoyi.system.mms;

import lombok.Data;

import java.util.Date;

/**
 * @author hmbfe
 * @version：
 * @date 2020-02-20 23:23
 * @description：
 */
@Data
public class User {
    /** 用户表id */
    private Integer mmsUid;
    /** 用户账号 */
    private String mmsUsername;
    /** 用户密码 */
    private String mmsPassword;
    /**结果状态码*/
    private String code;
    /**结果描述*/
    private String message;
    /** 时间戳 */
    private String reqTime;
    /** 添加时间 */
    private Date insertTime;
    /** 更新时间 */
    private Date updateTime;
    /** token */
    private String mmsToken;
}

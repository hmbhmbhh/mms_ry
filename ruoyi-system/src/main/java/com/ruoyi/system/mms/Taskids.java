package com.ruoyi.system.mms;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author hmbfe
 * @version：
 * @date 2020-02-23 15:59
 * @description：任务发送返回内容表 mms_taskids
 */
@Data
public class Taskids extends BaseEntity {
    /** 任务表id */
    private Long mmsTaskids;
    /** 任务id,一个或多个 */
    private String taskIds;
    /** 彩信id */
    private String mmsId;
    /** 产品id */
    private String productId;
    /** 任务发送状态:0-成功,其它-失败 */
    private String status;
    /** 添加时间 */
    private Date insertTime;
    /** 更新时间 */
    private Date updateTime;
}

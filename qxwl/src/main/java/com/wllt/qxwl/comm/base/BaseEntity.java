package com.wllt.qxwl.comm.base;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.utils.DateUtils;
import com.wllt.qxwl.comm.utils.SnowFlakeUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @author smxzk32145745@163.com
 */
@Data
public abstract class BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id = SnowFlakeUtils.getFlowIdInstance().nextId();
    private Integer status = CommonConstant.STATUS_NORMAL;
    private String description;
    private Integer sortOrder =0 ;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String createTime = DateUtils.getDateTime();
    private String createBy = "sysAdmin";
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String updateTime = DateUtils.getDateTime();
    private String updateBy = "sysAdmin";

}

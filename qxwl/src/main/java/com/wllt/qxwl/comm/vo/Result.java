package com.wllt.qxwl.comm.vo;


import lombok.Data;

import java.io.Serializable;

/**
 * @author Tian-Quanyou
 * @version V1.0
 * @Description: 前后端交互数据标准
 * @date 2020/4/20 22:49
 */
@Data
public class Result<T> implements Serializable {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 状态码
     */
    private String status;
    /**
     * 错误说明
     */
    private String msg;
    /**
     * 结果数据
     */
    private T result;

    public Result() {
        this.success = false;
    }

    public Result(boolean success, String status, String msg) {
        this.success = success;
        this.status = status;
        this.msg = msg;
    }

    public Result(boolean success, String status, String msg, T model) {
        this.success = success;
        this.status = status;
        this.msg = msg;
        this.result = model;
    }


    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}

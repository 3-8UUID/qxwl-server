package com.wllt.qxwl.comm.vo;


import lombok.Data;

import java.io.Serializable;

/**
* @Description: 前后端交互数据标准
* @author Tian-Quanyou
* @date 2020/4/20 22:49
* @version V1.0
*/
@Data
public class Result<T> implements Serializable {
     /**
     * 是否成功
     */
     private boolean success;
     /**
         * 错误代码
         */
     private String errcode;
     /**
         * 错误说明
         */
    private String errmsg;
    /**
     * 结果数据
     */
    private T result;

    public Result() {
        this.success =false;
    }

    public Result(boolean success, String errcode, String errmsg) {
        this.success = success;
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public Result(boolean success, String errcode, String errmsg, T model) {
        this.success = success;
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.result = model;
    }


        @Override
    public String toString() {
            return "Result{" +
                    "errcode='" + errcode + '\'' +
                    ", errmsg='" + errmsg + '\'' +
                    ", result=" + result  +
                    '}';
        }
}

package com.wllt.qxwl.comm.utils;


import com.wllt.qxwl.comm.enums.CommonErrors;
import com.wllt.qxwl.comm.vo.Result;

/**
* @Description: 前端交接工具类
* @throws
* @author Tian-Quanyou
* @date 2020/4/18 15:24
* @version V1.0
*/
public class ResultUtil {
    private ResultUtil(){

    }
    public static Result success(){
        return new Result(true, CommonErrors.SUCCESS.getCode(),CommonErrors.SUCCESS.getMsg(),null);
    }
    public static Result success(Object model){
        return new Result(true, CommonErrors.SUCCESS.getCode(),CommonErrors.SUCCESS.getMsg(),model);
    }
    public static Result fail(){
        return new Result(false, CommonErrors.FAIL.getCode(),CommonErrors.FAIL.getMsg(),null);
    }
    public static Result fail(Object model){
        return new Result(false, CommonErrors.FAIL.getCode(),CommonErrors.FAIL.getMsg(),model);
    }
    public static Result fail(String errCode,String errMsg){
        return new Result(false,errCode,errMsg,null);
    }
    public static Result fail(String errCode,String errMsg,Object model){
        return new Result(false,errCode,errMsg,model);
    }
}

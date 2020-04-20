package com.wllt.qxwl.comm.constant;

/**
 * @program: qms_server
 * @description: 结果返回常量
 * @author: Tian-Quanyou
 * @create: 2020-03-27 14:05
 **/
public interface ResultConstant {
    /** 保存成功 **/
    String RESULT_SAVE_SUCCESS =  "保存成功";
    /** 修改成功 **/
    String RESULT_MODIFY_SUCCESS =  "修改成功";
    /** 删除成功 **/
    String RESULT_DELETED_SUCCESS =  "删除成功";
    /** 保存失败 **/
    String RESULT_SAVE_FAIL =  "保存失败";
    /** 修改失败 **/
    String RESULT_MODIFY_FAIL =  "修改失败";
    /** 删除失败 **/
    String RESULT_DELETED_FAIL =  "删除失败";

    /** 登录失败 **/
    String RESULT_LOGIN_FAIL =  "认证失败";
    /** 登录成功 **/
    String RESULT_LOGIN_SUCCESS =  "登录成功";


    /** 注册失败 **/
    String RESULT_REGISTER_FAIL =  "注册失败，存在不合法值！";
    /** 注册成功 **/
    String RESULT_REGISTER_SUCCESS =  "注册成功，快去登录吧！";



}

package com.wllt.qxwl.comm.enums;

/**
 * 通用错误
 *
 * @author Saintcy
 */
public enum CommonErrors {
    /**
     * 处理成功
     */
    SUCCESS("0000", "成功"),
    /**
     * 处理失败
     */
    FAIL("0010", "处理失败"),
    /**
     * AppID不合法
     */
    INVALID_APPID("0001", "AppID不合法"),
    /**
     * 签名验证失败
     */
    SIGNATURE_VERIFY_FAIL("0002", "签名验证失败"),
    /**
     * 没有权限
     */
    UNAUTHORIZED("0003", "没有权限"),
    /**
     * 参数错误
     */
    INVALID_PARAM("0004", "参数错误"),
    /**
     * 非法token或已失效
     */
    TOKEN_VERIFY_FAIL("0005", "非法token或已失效"),
    /**
     * 服务不存在
     */
    SERVICE_NOT_EXIST("0006", "服务不存在"),
    /**
     * 服务暂不可用
     */
    SERVICE_UNAVAILABLE("0007", "服务暂不可用"),
    /**
     * 未知错误
     */
    UNDEFINED("9999", "系统错误");

    public static CommonErrors codeOf(String code) {
        for (CommonErrors error : CommonErrors.values()) {
            if (error.code.equals(code)) {
                return error;
            }
        }
        throw new IllegalArgumentException("No enum constant com.freemaker.core.web.CommonErrors." + code);
    }

    /*************************************************************************************/
    /**
     * 编码
     */
    private String code;
    /**
     * 消息
     */
    private String msg;

    /**
     * 构造函数
     *
     * @param code
     * @param msg
     */
    CommonErrors(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "Errors{" +
            "code='" + code + '\'' +
            ", msg='" + msg + '\'' +
            "} " + super.toString();
    }
}

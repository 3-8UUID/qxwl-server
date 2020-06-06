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
    SUCCESS("200", "成功"),
    /**
     * 处理失败
     */
    FAIL("400", "处理失败"),



    ILLEGAL_REQUEST_PARAMETER("10000","非法请求参数"),

    NO_REQUEST_PERMISSION("10001","无权限访问"),

    TOKEN_EXPIRED("10002","token过期"),

    REFRESH_TOKEN_EXPIRED("10003","refresh_token过期"),

    INVALID_SIGNATURE("10004","签名无效/sign无效"),

    INVALID_APP_KEY("10005","app_key无效"),

    INVALID_TIMESTAMP_PARAMETER("10006","timestamp参数无效"),

    ILLEGAL_ACCESS_IP("10007","访问IP不合法"),

    /**
     * 未知错误
     */
    UNDEFINED("500", "系统错误");

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

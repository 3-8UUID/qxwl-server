package com.wllt.qxwl.comm.enums;

/**
 * Role枚举
 *
 * @author Tian-Quanyou
 * @version V1.0
 * @date 2020/6/6 14:08
 */
public enum RoleEnum {
    ROLE_USER(1, "ROLE_USER"),
    ROLE_ADMIN(2, "ROLE_ADMIN"),
    ROLE_SUPER_ADMIN(3, "ROLE_SUPER_ADMIN"),
    ROLE_SAFEGUARD(4, "ROLE_SAFEGUARD");


    /**
     * 编码
     */
    private Integer code;
    /**
     * 内容
     */
    private String value;

    /**
     * 构造函数
     *
     * @param code
     * @param value
     */
    RoleEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }

    /**
     * 根据代码获取ENUM
     *
     * @param code
     * @return
     */
    public static RoleEnum getByCode(int code) {
        for (RoleEnum e : RoleEnum.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

}

package com.wllt.qxwl.comm.enums;

/**
* @Description:  文件类型枚举
* @author Tian-Quanyou
* @date 2020/4/18 13:03
* @version V1.0
*/
public enum FileTypeEnum {
    /**
     文件格式 101-PNG 102-WAV 103-MP3 104-MP4 105-AVI"
     **/
    FILE_PNG(101,"PNG"),
    FILE_WAV(102, "WAV"),
    FILE_MP3(103, "MP3"),
    FILE_MP4(104, "MP4"),
    FILE_AVI(105, "AVI")

    ;

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
    FileTypeEnum(Integer code, String value) {
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
    public static FileTypeEnum getByCode(int code) {
        for (FileTypeEnum e : FileTypeEnum.values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    /**
     * 根据代码获取ENUM
     *
     * @param value
     * @return
     */
    public static FileTypeEnum getByValue(String value) {
        for (FileTypeEnum e : FileTypeEnum.values()) {
            if (value.equals(e.getValue())) {
                return e;
            }
        }
        return null;
    }

    public static String typeDesc(){
        String val = "";
        for (FileTypeEnum e : FileTypeEnum.values()) {
            val +=e.value + "|";
        }
        return val.substring(0,val.length()-1);
    }
}

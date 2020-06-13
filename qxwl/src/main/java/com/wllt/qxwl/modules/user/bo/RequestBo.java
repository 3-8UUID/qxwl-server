package com.wllt.qxwl.modules.user.bo;

import lombok.Data;

import java.io.Serializable;


@Data
public class RequestBo implements Serializable {
    private String token;
    private String userName = "system";
    private String displayName = "系统";
}

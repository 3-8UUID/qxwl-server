package com.wllt.qxwl.modules.post.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: qxwl_server
 * @description: 文章中模块
 * @author: Tian-Quanyou
 * @create: 2020-06-13 14:26
 **/
@Data
public class WlltContentVo implements Serializable {

    private Long id;
    /**
     * 模块图片
     */
    private String imgPath;

    /**
     * 模块描述
     */
    private String content;
}

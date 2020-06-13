package com.wllt.qxwl.comm.utils;


import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.modules.user.bo.RequestBo;

import javax.servlet.http.HttpServletRequest;

/**
 * ***********************************************************
 * Copyright © 2019 卓付杭州有限公司 Inc.All rights reserved.  *
 * ***********************************************************
 *
 * @Company: www.zhuofu.com
 * @Generator: IntelliJ IDEA
 * @Project: msx-ers
 * @Package: com.bwton.ers.infrastructure.common.util
 * @Name: DataUtils
 * @Author: zhaokaikai@bwton.com
 * @Date: 2019年04月25日 17时47分
 * @Description: 数据转换器
 */
public class RequestUtils {

    /**
     * 将请求的header转换为RequestDTO
     * @param request 请求体
     * @param requestDTO 转换结果
     */
    public static void builderRequestDTO(HttpServletRequest request, RequestBo requestDTO){

        if(null==request){return;}
        String token = request.getHeader(CommonConstant.AUTH_TOKEN);
        requestDTO.setToken(token);

    }
}

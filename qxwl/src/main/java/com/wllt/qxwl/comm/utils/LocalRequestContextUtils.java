package com.wllt.qxwl.comm.utils;


import com.wllt.qxwl.modules.user.bo.RequestBo;
import com.wllt.qxwl.modules.user.entity.WlltUser;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LocalRequestContextUtils {
    /**
     * //todo context必须要有清空方法
     */
    private final static ThreadLocal<LocalRequestContext> contexts = new ThreadLocal<LocalRequestContext>();

    private LocalRequestContextUtils(){}

    /**
     * 初始化当前请求的上下文
     * @param servletContext
     * @param httpServletRequest
     * @param httpServletResponse
     */
    public static void setLocalRequestContext(ServletContext servletContext, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
            , WlltUser wlltUser) {
        LocalRequestContext localRequestContext = new LocalRequestContext();
        localRequestContext.servletContext = servletContext;
        localRequestContext.request = httpServletRequest;
        localRequestContext.response = httpServletResponse;
        if(!ObjectUtils.isEmpty(wlltUser)) {
            localRequestContext.wlltUser = wlltUser;
        }

        //当前请求头Request
        RequestBo requestDTO = new RequestBo();
        RequestUtils.builderRequestDTO(httpServletRequest,requestDTO);
        localRequestContext.requestBO = requestDTO;
        contexts.set(localRequestContext);
    }

    public static void remove(){
        contexts.remove();
    }

    public static RequestBo getRequestBO(){
        if(null == contexts.get()){
            return new RequestBo();
        }
        return contexts.get().getRequestBO();
    }
    public static WlltUser getWlltUser(){
        if(null == contexts.get()){
            return null;
        }
        return contexts.get().getWlltUser();
    }
    public static void setWlltUser(WlltUser wlltUser){
        if(null == contexts.get()){
            return;
        }
        contexts.get().setWlltUser(wlltUser);
    }
}

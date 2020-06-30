package com.wllt.qxwl.comm.utils;


import com.wllt.qxwl.modules.account.user.bo.RequestBo;
import com.wllt.qxwl.modules.account.user.entity.WlltUser;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LocalRequestContext {
    public ServletContext servletContext;
    public HttpServletRequest request;
    public HttpServletResponse response;
    public RequestBo requestBO;
    public WlltUser wlltUser;

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public RequestBo getRequestBO() {
        return requestBO;
    }

    public void setRequestBO(RequestBo requestBO) {
        this.requestBO = requestBO;
    }


    public WlltUser getWlltUser() {
        return wlltUser;
    }

    public void setWlltUser(WlltUser wlltUser) {
        this.wlltUser = wlltUser;
    }
}

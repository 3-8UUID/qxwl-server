package com.wllt.qxwl.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: qxwl_server
 * @description: 登录失败处理器
 * @author: Tian-Quanyou
 * @create: 2020-06-07 11:39
 **/
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        Result fail = ResultUtil.fail("400", "登录失败!");
        out.write(JSON.toJSONString(fail));
        out.flush();
        out.close();
    }
}

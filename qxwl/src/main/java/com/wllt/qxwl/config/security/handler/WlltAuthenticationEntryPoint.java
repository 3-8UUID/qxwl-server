package com.wllt.qxwl.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: qxwl_server
 * @description: 无权限处理器
 * @author: Tian-Quanyou
 * @create: 2020-06-07 11:34
 **/
@Component
public class WlltAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        Result fail = ResultUtil.fail("403", "权限不足，请联系管理员!");
        out.write(JSON.toJSONString(fail));
        out.flush();
        out.close();
    }
}

package com.wllt.qxwl.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.utils.JwtTokenUtil;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.config.security.dto.WlltUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: qxwl_server
 * @description: 登录成功处理器
 * @author: Tian-Quanyou
 * @create: 2020-06-07 11:41
 **/
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
        WlltUserDetail userDetails = (WlltUserDetail) auth.getPrincipal();
        System.out.println("userDetails = " + userDetails);
        String token = JwtTokenUtil.createToken(userDetails.getUsername(), userDetails.getRoles());

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader(CommonConstant.AUTH_TOKEN, token);
        PrintWriter out = resp.getWriter();
        Result success = ResultUtil.success("登录成功");
        out.write(JSON.toJSONString(success));
        out.flush();
        out.close();
    }
}

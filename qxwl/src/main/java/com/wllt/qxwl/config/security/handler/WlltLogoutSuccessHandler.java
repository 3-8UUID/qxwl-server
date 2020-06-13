package com.wllt.qxwl.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: qxwl_server
 * @description: 登出处理器
 * @author: Tian-Quanyou
 * @create: 2020-06-07 11:48
 **/
@Component
public class WlltLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
        resp.setStatus(HttpServletResponse.SC_CONTINUE);
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        //todo 把token清除掉
        Result success = ResultUtil.success("登出成功");
        out.write(JSON.toJSONString(success));
        out.flush();
        out.close();
    }
}

package com.wllt.qxwl.config.security.handler;

import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.utils.JwtTokenUtil;
import com.wllt.qxwl.comm.utils.LocalRequestContextUtils;
import com.wllt.qxwl.config.security.service.WlltUserDetailServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: qxwl_server
 * @description: token校验处理
 * @author: Tian-Quanyou
 * @create: 2020-06-07 14:20
 **/
@Component
public class WlltAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private WlltUserDetailServiceImpl wlltUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String token = req.getHeader(CommonConstant.AUTH_TOKEN);
        //token 是否过期
        if (StringUtils.isNotEmpty(token)) {
//            if (!JwtTokenUtil.isExpiration(token)) {//tODO 过期有问题
            String username = JwtTokenUtil.getUsername(token);
            if (StringUtils.isNotEmpty(username)) {
                UserDetails userDetails = wlltUserDetailService.loadUserByUsername(username);
                if (!ObjectUtils.isEmpty(userDetails)) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                    LocalRequestContextUtils.setLocalRequestContext(req.getServletContext(),req,resp,null);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
//            }
        }
        chain.doFilter(req, resp);
    }
}

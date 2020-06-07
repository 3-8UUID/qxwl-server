package com.wllt.qxwl.config.security;

import com.wllt.qxwl.config.security.handler.*;
import com.wllt.qxwl.config.security.service.WlltUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @program: qxwl_server
 * @description: 终端处理控制
 * @author: Tian-Quanyou
 * @create: 2020-06-07 11:52
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled =true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyAuthenticationEntryPoint myAuthenticationEntryPoint;  //  未登陆时返回 JSON 格式的数据给前端（否则为 html）

    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;  // 登录成功返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;  //  登录失败返回的 JSON 格式数据给前端（否则为 html）

    @Autowired
    MyLogoutSuccessHandler myLogoutSuccessHandler;  // 注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）

//    @Autowired
//    AjaxAccessDeniedHandler accessDeniedHandler;    // 无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）

    @Autowired
    WlltUserDetailServiceImpl userDetailsService; // 自定义user
//
    @Autowired
    MyAuthenticationTokenFilter myAuthenticationTokenFilter; // JWT 拦截器


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/qxwl/sys/**","/qxwl/user/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic().authenticationEntryPoint(myAuthenticationEntryPoint)
                .and().formLogin()
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler).permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .permitAll()// 不需要session
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.rememberMe().rememberMeParameter("remember-me")
                .userDetailsService(userDetailsService).tokenValiditySeconds(300);

        // 无权访问 JSON 格式的数据
//        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        http.addFilterBefore(myAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**/**.css", "/static/**");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
    }
}

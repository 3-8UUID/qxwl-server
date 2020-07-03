package com.wllt.qxwl.comm.aspect;

import com.alibaba.fastjson.JSONObject;
import com.wllt.qxwl.comm.base.BaseController;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @program: qxwl_server
 * @description:
 * @author: Tian-Quanyou
 * @create: 2020-06-04 17:49
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Resource(name = "baseController")
    private BaseController baseController;

    //    @Pointcut("@annotation(com.wllt.qxwl.comm.annotation.ControllerLog)")
    @Pointcut("execution(* com.wllt.qxwl.modules.*.*.controller..*.*(..))" +
            "&& !execution(* com.wllt.qxwl.modules.article.source.controller.WlltSourceController.createResource(..)) ")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        long start = System.currentTimeMillis();
        log.info("=====================================Method  start====================================");
        try {
            // 执行方法
            result = point.proceed();
            // 保存请求日志
            saveRequestLog(point, start);
        } catch (Exception e) {
            // 保存异常日志
            return saveExceptionLog(point, e.getMessage(), start);
        }
        return result;
    }

    private Result saveExceptionLog(ProceedingJoinPoint point, String exeMsg, Long start) {
        log.info("捕获异常:{}", exeMsg);
        saveRequestLog(point, start);
        return ResultUtil.fail(exeMsg);
    }


    private void saveRequestLog(ProceedingJoinPoint point, Long start) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("请求路径:" + request.getRequestURL());
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        log.info("请求方法:" + method.getName());
        log.info("请求参数:" + JSONObject.toJSONString(point.getArgs()));
        log.info("请求IP地址:" + baseController.getClientIP());
        Long end = System.currentTimeMillis();
        log.info("执行时间: " + (end - start) + " ms!");
        log.info("=====================================Method  End====================================");
    }
}

//https://www.cnblogs.com/kingyifan/p/11721439.html
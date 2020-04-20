package com.wllt.qxwl.comm.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
* @Description: BaseController
* @throws
* @author Tian-Quanyou
* @date 2020/4/20 21:34
* @version V1.0
*/
public class BaseController {

    protected Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    protected HttpServletRequest request;

    /**
     * 获取当前请求
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * 获取当前会话
     *
     * @param isNew true:session不存在则创建
     * @return
     */
    public HttpSession getSession(boolean isNew) {
        if (request != null) {
            return request.getSession(isNew);
        }
        return null;
    }

    /**
     * 使用指定的名称将对象绑定到该会话
     *
     * @param key   Name of session
     * @param value Value of session
     */
    public void setSession(String key, String value) {
        getSession(true).setAttribute(key, value);
    }

    /**
     * 获取项目相对路径
     */
    public String getProjectPath() {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    /**
     * 获取项目物理路径
     */
    public String getProjectMirPath() {
        return getSession(true).getServletContext().getRealPath("/");
    }

    /**
     * 获取访问客户端IP
     */
    public String getClientIP() {
        if (request == null) {
            return null;
        }
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ipAddress;
    }

}
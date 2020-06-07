package com.wllt.qxwl.config.security.handler;

import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.utils.PasswordUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: qxwl_server
 * @description: 自定义密码校验
 * @author: Tian-Quanyou
 * @create: 2020-06-07 12:59
 **/
public class MyPasswordEncoder extends BCryptPasswordEncoder {

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword != null && encodedPassword.length() != 0) {
            boolean validPassword = PasswordUtils.isValidPassword(rawPassword.toString(), encodedPassword, CommonConstant.SALT);
//            validPassword = true;
            return validPassword;
        }
        return false;
    }
}

package com.wllt.qxwl.config.security.service;

import com.wllt.qxwl.config.security.dto.WlltUserDetail;
import com.wllt.qxwl.modules.user.entity.WlltUser;
import com.wllt.qxwl.modules.user.service.WlltUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @program: qxwl_server
 * @description:
 * @author: Tian-Quanyou
 * @create: 2020-06-06 17:37
 **/
@Service
public class WlltUserDetailServiceImpl  implements UserDetailsService {
    @Autowired
    private WlltUserService wlltUserService;

    //自定义校验鉴定身份
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WlltUser info = wlltUserService.getUserInfo(username);
        if (info == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        WlltUserDetail wlltUserDetail = new WlltUserDetail();
        BeanUtils.copyProperties(info, wlltUserDetail);
        return wlltUserDetail;
    }



}

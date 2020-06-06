package com.wllt.qxwl.modules.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.modules.user.entity.WlltUser;
import com.wllt.qxwl.modules.user.service.WlltUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: qxwl_server
 * @description:
 * @author: Tian-Quanyou
 * @create: 2020-06-02 22:01
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private WlltUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();

        //生成环境是查询数据库获取username的角色用于后续权限判断（如：张三 admin)
        QueryWrapper<WlltUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(WlltUser::getUsername,username);
        queryWrapper.lambda().eq(WlltUser::getStatus, CommonConstant.STATUS_NORMAL);
        WlltUser wlltUser = userService.getOne(queryWrapper);
        if (ObjectUtils.isNotEmpty(wlltUser)){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("admin");
            grantedAuthorities.add(grantedAuthority);
            //创建一个用户，用于判断权限，请注意此用户名和方法参数中的username一致；
            // BCryptPasswordEncoder是用来演示加密使用。
            System.out.println("before = " + wlltUser.getPassword());
            String encode = new BCryptPasswordEncoder().encode(wlltUser.getPassword());
            System.out.println("after = " + encode);
            return new User(wlltUser.getUsername(), encode, grantedAuthorities);
        } else {
            return null;
        }


    }
}
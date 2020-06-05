package com.wllt.qxwl.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.constant.RedisConstant;
import com.wllt.qxwl.comm.redis.RedisClient;
import com.wllt.qxwl.comm.utils.PasswordUtils;
import com.wllt.qxwl.modules.role.entity.WlltRole;
import com.wllt.qxwl.modules.role.service.WlltRoleService;
import com.wllt.qxwl.modules.user.bo.WlltUserBo;
import com.wllt.qxwl.modules.user.dao.WlltUserDao;
import com.wllt.qxwl.modules.user.entity.WlltUser;
import com.wllt.qxwl.modules.user.service.WlltUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Service
@Slf4j
public class WlltUserServiceImpl extends ServiceImpl<WlltUserDao, WlltUser> implements WlltUserService {


    @Autowired
    private RedisClient redisClient;

    @Autowired
    private WlltUserDao wlltUserDao;

    @Autowired
    private WlltRoleService wlltRoleService;

    @Override
    public List<WlltUser> find() {
        List<WlltUser> userList = (List<WlltUser>) redisClient.get("userList");
        if (null!=userList&&userList.size()>0){
            System.out.println("从REDIS中查询");
            return userList;
        }
        List<WlltUser> wlltUsers = wlltUserDao.find();
        redisClient.set("userList", wlltUsers, RedisConstant.EXRP_DAY);
        System.out.println("从数据库中查询");
        return wlltUsers;
    }

    @Override
    public WlltUser userLogin(@NotNull WlltUserBo userBo) {

        return null;
    }

    @Override
    public Boolean userRegister(WlltUserBo userBo) {
        WlltUser user = new WlltUser();
        user.setPassword(PasswordUtils.encodePassword(userBo.getPassword(),CommonConstant.SALT));
        user.setUserName(userBo.getUserName());
//        user.setMobile(userBo.getMobile());
        user.setSalt(CommonConstant.SALT);
        return save(user);
    }

    @Override
    public Boolean userModifyInfo(@NotNull WlltUser user) {
        if (StringUtils.isEmpty(user.getId())){
            return false;
        }
        return updateById(user);
    }

    @Override
    public List<WlltUser> findUsersByWhere(WlltUserBo userBo) {
        QueryWrapper<WlltUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(WlltUser::getId,userBo.getId());
        queryWrapper.lambda().eq(WlltUser::getUserName,userBo.getUserName()).orderByAsc(WlltUser::getSortOrder);
        queryWrapper.lambda().eq(WlltUser::getMobile,userBo.getMobile());
        queryWrapper.lambda().eq(WlltUser::getEmail,userBo.getEmail());
        queryWrapper.lambda().eq(WlltUser::getSex,userBo.getSex());
        queryWrapper.lambda().eq(WlltUser::getStatus, CommonConstant.STATUS_NORMAL);
        queryWrapper.lambda().eq(WlltUser::getNickName,userBo.getNickName());
        queryWrapper.lambda().eq(WlltUser::getAddress,userBo.getAddress());
        queryWrapper.lambda().eq(WlltUser::getWxNumber,userBo.getWxNumber());
        return list(queryWrapper);
    }



    @Override
    public WlltUser getUserInfo(String username) {
        WlltUser wlltUser = (WlltUser) redisClient.get(username);
        if (ObjectUtils.isEmpty(wlltUser)){
            QueryWrapper<WlltUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(WlltUser::getUserName,username);
            WlltUser user = getOne(queryWrapper);
            if (null == user){
                log.error("用户不存在");
                return null;
            }
            redisClient.set(username,user, RedisConstant.EXRP_DAY);
        }
        return wlltUser;
    }


    @Override
    public List<String> getUserRoles(Long id) {
        QueryWrapper<WlltRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(WlltRole::getUserId,id);
        List<WlltRole> list = wlltRoleService.list(queryWrapper);
        List<String> roles = null;
        if (null==list||list.size()==0){
            return null;
        }
        roles = new ArrayList<>();
        for (WlltRole role:list
             ) {
            roles.add(role.getRole());
        }
        return roles;
    }


}

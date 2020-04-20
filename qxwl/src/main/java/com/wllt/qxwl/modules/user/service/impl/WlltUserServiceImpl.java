package com.wllt.qxwl.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.redis.RedisClient;
import com.wllt.qxwl.modules.role.entity.WlltRole;
import com.wllt.qxwl.modules.role.service.WlltRoleService;
import com.wllt.qxwl.modules.user.bo.WlltUserBo;
import com.wllt.qxwl.modules.user.dao.WlltUserDao;
import com.wllt.qxwl.modules.user.entity.WlltUser;
import com.wllt.qxwl.modules.user.service.WlltUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        redisClient.set("userList",wlltUsers);
        System.out.println("从数据库中查询");
        return wlltUsers;
    }

    @Override
    public WlltUser userLogin(@NotNull WlltUserBo userBo) {
        log.info(CommonConstant.PARAM_IN,userBo);

        return null;
    }

    @Override
    public Boolean userRegister(WlltUserBo userBo) {
        log.info(CommonConstant.PARAM_IN,userBo);
//        Boolean flag = null;
//        if (StringUtils.isEmpty(userBo.getFlag())){
//            return flag;
//        }
//        WlltUser user = new WlltUser();
//        user.setPassword(userBo.getPassword().toString());
//        if (userBo.getFlag()==CommonConstant.USER_FLAG_NAME){
//            user.setUserName(userBo.getUserName());
//        }else if (userBo.getFlag()==CommonConstant.USER_FLAG_MOBILE){
//            user.setMobile(userBo.getMobile());
//        }else if (userBo.getFlag()==CommonConstant.USER_FLAG_EMAIL){
//            user.setEmail(userBo.getEmail());
//        }else if (userBo.getFlag()==CommonConstant.USER_FLAG_WX){
//            //微信号+密码登录
//            user.setWxNumber(userBo.getWxNumber());
//        }
//        user.setSalt(JwtUtils.generateSalt());
//        return save(user);
        return null;
    }

    @Override
    public Boolean userModifyInfo(@NotNull WlltUser user) {
        log.info(CommonConstant.PARAM_IN,user);
        if (StringUtils.isEmpty(user.getId())){
            return false;
        }
        return updateById(user);
    }

    @Override
    public List<WlltUser> findUsersByWhere(WlltUserBo userBo) {
        log.info(CommonConstant.PARAM_IN,userBo);
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
        QueryWrapper<WlltUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(WlltUser::getUserName,username);
        //TODO 后期把user存入redis
        return this.getOne(queryWrapper);
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

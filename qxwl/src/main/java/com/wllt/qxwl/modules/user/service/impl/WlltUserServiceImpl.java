package com.wllt.qxwl.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllt.qxwl.comm.constant.CommonConstant;
import com.wllt.qxwl.comm.constant.RedisConstant;
import com.wllt.qxwl.comm.enums.RoleEnum;
import com.wllt.qxwl.comm.redis.RedisClient;
import com.wllt.qxwl.comm.utils.JwtTokenUtil;
import com.wllt.qxwl.comm.utils.LocalRequestContextUtils;
import com.wllt.qxwl.comm.utils.PasswordUtils;
import com.wllt.qxwl.modules.relation.entity.RelationUR;
import com.wllt.qxwl.modules.relation.service.RelationURService;
import com.wllt.qxwl.modules.role.entity.WlltRole;
import com.wllt.qxwl.modules.role.service.WlltRoleService;
import com.wllt.qxwl.modules.user.bo.WlltUserBo;
import com.wllt.qxwl.modules.user.dao.WlltUserDao;
import com.wllt.qxwl.modules.user.entity.WlltUser;
import com.wllt.qxwl.modules.user.service.WlltUserService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 服务实现类
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
    private RelationURService urService;

    @Autowired
    private WlltRoleService wlltRoleService;



    @Override
    public List<WlltUser> find() {
        List<WlltUser> userList = (List<WlltUser>) redisClient.get("list");
        if (!ObjectUtils.isEmpty(userList)) {
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean userRegister(WlltUserBo userBo) {
        WlltUser user = new WlltUser();
        //TODO 密码自定义加密
        user.setPassword(PasswordUtils.encodePassword(userBo.getPassword(),CommonConstant.SALT));
        user.setUsername(userBo.getUsername());
        user.setSalt(CommonConstant.SALT);
        boolean save = save(user);
        if (save){
            //注册默认普通用户
            Boolean aBoolean = wlltRoleService.addRole(user.getId(), RoleEnum.ROLE_USER.getCode());
            return aBoolean;
        }
        return false;
    }

    @Override
    public Boolean userModifyInfo(@NotNull WlltUser user) {
        if (StringUtils.isEmpty(user.getId())) {
            return false;
        }
        return updateById(user);
    }

    @Override
    public List<WlltUser> findUsersByWhere(WlltUserBo userBo) {
        QueryWrapper<WlltUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(WlltUser::getId, userBo.getId());
        queryWrapper.lambda().eq(WlltUser::getUsername, userBo.getUsername()).orderByAsc(WlltUser::getSortOrder);
        queryWrapper.lambda().eq(WlltUser::getMobile, userBo.getMobile());
        queryWrapper.lambda().eq(WlltUser::getEmail, userBo.getEmail());
        queryWrapper.lambda().eq(WlltUser::getSex, userBo.getSex());
        queryWrapper.lambda().eq(WlltUser::getStatus, CommonConstant.STATUS_NORMAL);
        queryWrapper.lambda().eq(WlltUser::getUsername, userBo.getNickname());
        queryWrapper.lambda().eq(WlltUser::getAddress, userBo.getAddress());
        queryWrapper.lambda().eq(WlltUser::getWxNumber, userBo.getWxNumber());
        return list(queryWrapper);
    }


    @Override
    public WlltUser getUserInfo(String username) {
        WlltUser wlltUser = (WlltUser) redisClient.get(username);
        if (ObjectUtils.isEmpty(wlltUser)) {
            QueryWrapper<WlltUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(WlltUser::getUsername, username);
            WlltUser user = getOne(queryWrapper);
            if (null == user) {
                log.error("用户不存在");
                return null;
            }
            redisClient.set(username, user, RedisConstant.EXRP_DAY);
        }
        //考虑角色会变动不存入redis中了
        List<WlltRole> roles = getUserRoles(wlltUser.getId());
        List<String> rs = Lists.newArrayList();
        roles.forEach(role->{
            rs.add(role.getRole());
        });
        wlltUser.setRoles(rs);
        return wlltUser;
    }


    @Override
    public List<WlltRole> getUserRoles(Long id) {
        List<WlltRole> roles = Lists.newArrayList();
        QueryWrapper<RelationUR> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(RelationUR::getUserId,id);
        wrapper.lambda().eq(RelationUR::getStatus,CommonConstant.STATUS_NORMAL);
        urService.list(wrapper).forEach(ur->{
            WlltRole role = wlltRoleService.getById(ur.getRoleId());
            roles.add(role);
        });
        return roles;
    }

    @Override
    public WlltUser getLoginUser() {
        String token = LocalRequestContextUtils.getRequestBO().getToken();
        String username = JwtTokenUtil.getUsername(token);
        return getUserInfo(username);
    }


}

package com.wllt.qxwl.modules.account.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllt.qxwl.modules.account.role.entity.WlltRole;
import com.wllt.qxwl.modules.account.user.bo.WlltUserBo;
import com.wllt.qxwl.modules.account.user.entity.WlltUser;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
public interface WlltUserService extends IService<WlltUser> {

    List<WlltUser> find();

    /**
     * 登录
     * @param userBo
     * @return
     */
    WlltUser userLogin(@NotNull WlltUserBo userBo);

    /**
     * 注册
     * @param userBo
     * @return
     */
    Boolean userRegister(@NotNull WlltUserBo userBo);

    /**
     * 用户修改信息
     * @param user
     * @return
     */
    Boolean userModifyInfo(@NotNull WlltUser user);

    /**
    * @Description: 条件查询用户信息
    * @throws
    * @author Tian-Quanyou
    * @date 2020/4/18 15:27
    * @version V1.0
    */
    List<WlltUser> findUsersByWhere(WlltUserBo userBo);


    WlltUser getUserInfo(String username);

    List<WlltRole> getUserRoles(Long id);

    WlltUser getLoginUser();


}

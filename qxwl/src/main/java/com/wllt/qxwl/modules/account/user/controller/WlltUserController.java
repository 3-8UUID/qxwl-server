package com.wllt.qxwl.modules.account.user.controller;


import com.wllt.qxwl.comm.constant.ResultConstant;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.account.role.entity.WlltRole;
import com.wllt.qxwl.modules.account.user.bo.WlltUserBo;
import com.wllt.qxwl.modules.account.user.entity.WlltUser;
import com.wllt.qxwl.modules.account.user.service.WlltUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@Slf4j
@RestController
@RequestMapping("/qxwl/user")
public class WlltUserController {
    @Autowired
    private WlltUserService wlltUserService;

    @RequestMapping("/getAllList")
    public Result getList(){
        List<WlltUser> list = wlltUserService.find();
        return ResultUtil.success(list);
    }

    @RequestMapping("/getLoginUser")
    public WlltUser getLoginUser(){
        return wlltUserService.getLoginUser();
    }

    /**
     * 根据条件查询用户信息
     *
     * @param userBo
     * @return
     */
    @PostMapping("findList")
    public Result getListByWhere(@RequestBody @NotNull WlltUserBo userBo) {
        List<WlltUser> list = wlltUserService.findUsersByWhere(userBo);
        return ResultUtil.success(list);
    }

    /**
     * 登录
     *
     * @param userBo
     * @return
     */
    @PostMapping("/loginUp")//loginUp
    public ResponseEntity<Void> login(@RequestBody WlltUserBo userBo, HttpServletRequest request, HttpServletResponse response) {

        return null;
    }

    /**
     * 注册
     *
     * @param userBo
     * @return
     */
    @PostMapping("/register")//register
    public Result userRegister(@Validated @RequestBody WlltUserBo userBo) {
        Boolean aBoolean = wlltUserService.userRegister(userBo);
        if (aBoolean) {
            return ResultUtil.success(ResultConstant.RESULT_REGISTER_SUCCESS);
        }
        return ResultUtil.fail(ResultConstant.RESULT_REGISTER_FAIL);
    }

    @RequestMapping("/loginOut")
    public ResponseEntity<Void> logout() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/getRoles")
    @PreAuthorize("hasRole('ADMIN')")
    public Result getRoleByUserId(@RequestBody WlltUserBo userBo){
        List<WlltRole> roles = wlltUserService.getUserRoles(userBo.getId());
        return ResultUtil.success(roles);
    }
}

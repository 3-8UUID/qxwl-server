package com.wllt.qxwl.modules.user.controller;


import com.wllt.qxwl.comm.base.BaseController;
import com.wllt.qxwl.comm.constant.ResultConstant;
import com.wllt.qxwl.comm.constant.WLLTUrlConstant;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.user.bo.WlltUserBo;
import com.wllt.qxwl.modules.user.entity.WlltUser;
import com.wllt.qxwl.modules.user.service.WlltUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/qxwl/user/wlltUser")
public class WlltUserController extends BaseController {
    @Autowired
    private WlltUserService wlltUserService;

    @RequestMapping(WLLTUrlConstant.URL_LIST)
    public Result getList(){
        System.out.println("this.getClientIP() = " + this.getClientIP());
        List<WlltUser> list = wlltUserService.find();
        return ResultUtil.success(list);
    }


    /**
     * 根据条件查询用户信息
     *
     * @param userBo
     * @return
     */
    @PostMapping(WLLTUrlConstant.URL_FIND_LIST)
    public Result getListByWhere(@RequestBody @NotNull WlltUserBo userBo) {
        System.out.println("this.getClientIP() = " + this.getClientIP());
        List<WlltUser> list = wlltUserService.findUsersByWhere(userBo);
        return ResultUtil.success(list);
    }

    /**
     * 登录
     *
     * @param userBo
     * @return
     */
    @PostMapping(WLLTUrlConstant.URL_LOGIN_UP)
    public ResponseEntity<Void> login(@RequestBody WlltUserBo userBo, HttpServletRequest request, HttpServletResponse response) {


//        Subject subject = SecurityUtils.getSubject();
//        try {
//            //将用户请求参数封装后，直接提交给Shiro处理
//            UsernamePasswordToken token = null;
//            if (userBo.getFlag() == CommonConstant.USER_FLAG_NAME) {
//                token = new UsernamePasswordToken(userBo.getUserName(), userBo.getPassword());
//            } else if (userBo.getFlag() == CommonConstant.USER_FLAG_MOBILE) {
//                token = new UsernamePasswordToken(userBo.getMobile(), userBo.getPassword());
//            } else if (userBo.getFlag() == CommonConstant.USER_FLAG_EMAIL) {
//                token = new UsernamePasswordToken(userBo.getEmail(), userBo.getPassword());
//            } else if (userBo.getFlag() == CommonConstant.USER_FLAG_WX) {
//                token = new UsernamePasswordToken(userBo.getWxNumber(), userBo.getPassword());
//            }
//            subject.login(token);
//            //Shiro认证通过后会将user信息放到subject内，生成token并返回
//            WlltUserBo user = (WlltUserBo) subject.getPrincipal();
//            String newToken = wlltUserService.generateJwtToken(user);
//            response.setHeader("x-auth-token", newToken);
//
//            return ResponseEntity.ok().build();
//        } catch (AuthenticationException e) {
//            // 如果校验失败，shiro会抛出异常，返回客户端失败
//            log.error("User " + userBo.getUserName() + " login fail, Reason:" + e.getMessage());
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
        return null;
    }

    /**
     * 注册
     *
     * @param userBo
     * @return
     */
    @PostMapping(WLLTUrlConstant.URL_REGISTER)
    public Result userRegister(@RequestBody WlltUserBo userBo) {
        Boolean aBoolean = wlltUserService.userRegister(userBo);
        if (aBoolean) {
            return ResultUtil.success(ResultConstant.RESULT_REGISTER_SUCCESS);
        }
        return ResultUtil.fail(ResultConstant.RESULT_REGISTER_FAIL);
    }

    @RequestMapping(WLLTUrlConstant.URL_LOGIN_OUT)
    public ResponseEntity<Void> logout() {
//        Subject subject = SecurityUtils.getSubject();
//        if (subject.getPrincipals() != null) {
//            WlltUserBo user = (WlltUserBo) subject.getPrincipals().getPrimaryPrincipal();
//            wlltUserService.deleteLoginInfo(user.getUserName());
//        }
//        SecurityUtils.getSubject().logout();
        return ResponseEntity.ok().build();
    }
}

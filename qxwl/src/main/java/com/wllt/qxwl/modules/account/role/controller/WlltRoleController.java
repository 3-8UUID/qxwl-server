package com.wllt.qxwl.modules.account.role.controller;

import com.wllt.qxwl.comm.constant.ResultConstant;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.account.role.entity.WlltRole;
import com.wllt.qxwl.modules.account.role.service.WlltRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * (WlltRole)表控制层
 *
 * @author makejava
 * @since 2020-06-06 12:57:15
 */
@RestController
@RequestMapping("qxwl/role")
public class WlltRoleController {
    /**
     * 服务对象
     */
    @Autowired
    private WlltRoleService wlltRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public WlltRole selectOne(Long id) {
        return this.wlltRoleService.queryById(id);
    }


 /*   @RequestMapping("/saveRole")
    public void save(){
        WlltRole role = new WlltRole();
        role.setRole("ROLE_USER");
        role.setDescription("普通用户");
        WlltRole role2 = new WlltRole();
        role2.setRole("ROLE_ADMIN");
        role2.setDescription("管理员");
        WlltRole role3 = new WlltRole();
        role3.setRole("ROLE_SUPER_ADMIN");
        role3.setDescription("开发者权限用户");
        WlltRole role4 = new WlltRole();
        role4.setRole("ROLE_SAFEGUARD");
        role4.setDescription("维护人员");
        ArrayList<WlltRole> list = Lists.newArrayList();
        list.add(role);
        list.add(role2);
        list.add(role3);
        list.add(role4);
        wlltRoleService.saveBatch(list);
    }*/

    @RequestMapping("/addRole")
    public Result addRole(@RequestParam(value = "userId") Long userId, @RequestParam(value = "roleCode")Integer roleCode) {
        Boolean add = wlltRoleService.addRole(userId, roleCode);
        if (add) {
            return ResultUtil.success(ResultConstant.RESULT_ADD_SUCCESS);
        }
        return ResultUtil.fail(ResultConstant.RESULT_ADD_FAIL);
    }

}
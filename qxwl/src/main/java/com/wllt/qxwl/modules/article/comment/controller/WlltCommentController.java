package com.wllt.qxwl.modules.article.comment.controller;


import com.wllt.qxwl.comm.constant.ResultConstant;
import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import com.wllt.qxwl.modules.article.comment.bo.WlltCommentBo;
import com.wllt.qxwl.modules.article.comment.entity.WlltComment;
import com.wllt.qxwl.modules.article.comment.service.WlltCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Devil
 * @since 2020-04-11
 */
@RestController
@RequestMapping("/qxwl/comment")
public class WlltCommentController {

    @Autowired
    private WlltCommentService wlltCommentService;


    @PostMapping("save")
    public Result save(@RequestBody WlltCommentBo wlltCommentBo) {
        WlltComment wlltComment = wlltCommentService.createOrModify(wlltCommentBo);
        if (ObjectUtils.isEmpty(wlltComment)) {
            return ResultUtil.fail(ResultConstant.RESULT_SAVE_FAIL);
        }
        return ResultUtil.success(wlltComment);
    }
}

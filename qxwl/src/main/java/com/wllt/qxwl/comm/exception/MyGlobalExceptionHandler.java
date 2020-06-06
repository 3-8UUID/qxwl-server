package com.wllt.qxwl.comm.exception;

import com.wllt.qxwl.comm.utils.ResultUtil;
import com.wllt.qxwl.comm.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * 全局异常处理器
* @Description: 在spring 3.2中，新增了@ControllerAdvice 注解，可以用于定义@ExceptionHandler、InitBinder、@ModelAttribute，并应用到所有@RequestMapping中
* @author Tian-Quanyou
* @date 2020/6/6 16:23
* @version V1.0
*/
@Slf4j
@RestControllerAdvice
public class MyGlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(MyGlobalExceptionHandler.class);

    /**
     * 自定义异常处理
     */
    @ExceptionHandler(value = MyException.class)
    public Result myException(MyException be) {
        log.error("自定义异常：", be);
        if(be.getCode() != null){
            return ResultUtil.fail(be.getCode().toString(), be.getMessage());
        }
        return ResultUtil.fail( be.getMessage() );
    }

    // 参数校验异常处理 ===========================================================================
    // MethodArgumentNotValidException是springBoot中进行绑定参数校验时的异常,需要在springBoot中处理,其他需要处理ConstraintViolationException异常进行处理.

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException( MethodArgumentNotValidException e ) {
        log.error( "方法参数校验:" + e.getMessage(), e );
        return ResultUtil.fail( e.getBindingResult().getFieldError().getDefaultMessage() );
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public Result handleValidationException(ValidationException e) {
        log.error( "ValidationException:", e );
        return ResultUtil.fail( e.getCause().getMessage() );
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleConstraintViolationException(ConstraintViolationException e) {
        log.error( "ValidationException:" + e.getMessage(), e );
        return ResultUtil.fail( e.getMessage() );
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNoFoundException(Exception e) {
        return ResultUtil.fail( "404", "路径不存在，请检查路径是否正确" );
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        return ResultUtil.fail( "数据重复，请检查后提交" );
    }




    //    ===============================================

    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(RuntimeException e) {
        LOG.error("系统异常:", e);
        return ResultUtil.fail("系统异常，操作失败");
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerExceptionHandler(NullPointerException ex) {
        log.error("空指针异常:", ex);
        return ResultUtil.fail("空指针异常!");
    }

    /**
     * 类型转换异常
     */
    @ExceptionHandler(ClassCastException.class)
    public Result classCastExceptionHandler(ClassCastException ex) {
        log.error("类型转换异常:", ex);
        return ResultUtil.fail("类型转换异常!");
    }

    /**
     * 数组越界异常
     */
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public Result ArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
        log.error("数组越界异常:", ex);
        return ResultUtil.fail("数组越界异常!");
    }

    /**
     * 其他错误
     */
    @ExceptionHandler({Exception.class})
    public Result exception(Exception ex) {
        log.error("其他错误:", ex);
        return ResultUtil.fail( "500", "其他错误："+ ex );
    }

}

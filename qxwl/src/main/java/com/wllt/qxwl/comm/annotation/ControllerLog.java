package com.wllt.qxwl.comm.annotation;
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {
    String value() default "";
}

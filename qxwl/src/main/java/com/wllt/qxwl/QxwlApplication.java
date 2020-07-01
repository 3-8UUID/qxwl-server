package com.wllt.qxwl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {
//        SecurityAutoConfiguration.class
//})
@SpringBootApplication
@MapperScan(value = "com.wllt.qxwl.modules.*.*.dao")
public class QxwlApplication {

    public static void main(String[] args) {
        SpringApplication.run(QxwlApplication.class, args);
    }


}

package com.wllt.qxwl;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = QxwlApplication.class)
class QxwlApplicationTests {

    @Autowired
    StringEncryptor stringEncryptor;


    public static void main(String[] args) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(1);
        System.out.println(encryptor.decrypt("LWCotPgKR+SsQLqN6bBwfbbSCtZ0i4ZDgwJ/7O9YvuM="));
    }

    @Test
    void contextLoads() {
        System.out.println(stringEncryptor.decrypt("nYHpp5gwPNFFy0wHj5KKZrRGMMWNmeNY"));
//        String ip = stringEncryptor.encrypt("47.102.208.247");
//        String dev = stringEncryptor.encrypt("qxwl_dev");
//        String dev_url = stringEncryptor.encrypt("jdbc:mysql://47.102.208.247:3306/qxwl_dev?useUnicode=true&characterEncoding=utf-8");
//        String test = stringEncryptor.encrypt("qxwl_test");
//        String test_url = stringEncryptor.encrypt("jdbc:mysql://47.102.208.247:3306/qxwl_test?useUnicode=true&characterEncoding=utf-8");
//        String pro = stringEncryptor.encrypt("qxwl");
//        String pro_url = stringEncryptor.encrypt("jdbc:mysql://47.102.208.247:3306/qxwl?useUnicode=true&characterEncoding=utf-8");
//        String pwd = stringEncryptor.encrypt("mysqlroot");
//        String redis = stringEncryptor.encrypt("wllt_qxwl@123");
//        System.out.println("pwd = " + pwd);
//        System.out.println("dev = " + dev);
//        System.out.println("dev_url = " + dev_url);
//        System.out.println("test = " + test);
//        System.out.println("test_url = " + test_url);
//        System.out.println("pro = " + pro);
//        System.out.println("pro_url = " + pro_url);
//        System.out.println("redis = " + redis);
//        System.out.println("ip = " + ip);
    }



}

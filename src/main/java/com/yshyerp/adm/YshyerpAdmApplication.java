package com.yshyerp.adm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yshyerp.adm.mapper")
@SpringBootApplication
public class YshyerpAdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(YshyerpAdmApplication.class, args);
    }

}

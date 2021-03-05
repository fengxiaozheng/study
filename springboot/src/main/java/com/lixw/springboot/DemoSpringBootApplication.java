package com.lixw.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author lixw
 * @date 2021/02/02
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.lixw.springboot.web.servlet")
public class DemoSpringBootApplication {

    public static void main(String[] args) {
//        new SpringApplication(DemoSpringBootApplication.class)
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }
}

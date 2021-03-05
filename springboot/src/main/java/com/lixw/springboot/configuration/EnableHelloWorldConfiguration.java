package com.lixw.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixw
 * @date 2021/02/07
 */
@Configuration
public class EnableHelloWorldConfiguration {

    @Bean
    public String helloWorld() {
        return "hello world";
    }
}

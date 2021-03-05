package com.lixw.springboot.bootstrap;

import com.lixw.springboot.condition.ConditionOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author lixw
 * @date 2021/02/24
 */
//@ConditionOnSystemProperty(name = "user.name", value = "lixw")
public class ConditionOnSystemPropertyBootstrap {

    @Bean
    @ConditionOnSystemProperty(name = "user.name", value = "lixw")
    public String helloWorld() {
        return "hello li";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String bean = context.getBean("helloWorld", String.class);
        System.out.println("bean = " + bean);
        context.close();
    }
}

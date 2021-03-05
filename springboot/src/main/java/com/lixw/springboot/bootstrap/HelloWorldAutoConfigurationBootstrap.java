package com.lixw.springboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lixw
 * @date 2021/02/24
 */
@EnableAutoConfiguration
public class HelloWorldAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(HelloWorldAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String bean = context.getBean("helloWorld", String.class);
        System.out.println("bean = " + bean);
        context.close();
    }
}

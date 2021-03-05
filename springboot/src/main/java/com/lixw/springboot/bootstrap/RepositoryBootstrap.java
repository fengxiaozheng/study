package com.lixw.springboot.bootstrap;

import com.lixw.springboot.repository.MyFirstRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lixw
 * @date 2021/02/07
 */
@ComponentScan(basePackages = "com.lixw.springboot.repository")
public class RepositoryBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        MyFirstRepository bean = context.getBean("myFirstRepository", MyFirstRepository.class);
        System.out.println("bean = " + bean);
        context.close();
    }
}

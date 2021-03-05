package com.lixw.springboot.configuration;

import com.lixw.springboot.annotation.EnableHelloWorld;
import com.lixw.springboot.condition.ConditionOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配
 *
 * @author lixw
 * @date 2021/02/24
 */
@Configuration //spring模式注解装配
@EnableHelloWorld //spring @Enable模块装配
@ConditionOnSystemProperty(name = "user.name", value = "lixw") //条件装配
public class EnableHelloWorldAutoConfiguration {

}

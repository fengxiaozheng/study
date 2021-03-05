package com.lixw.springboot.annotation;

import com.lixw.springboot.configuration.EnableHelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lixw
 * @date 2021/02/07
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EnableHelloWorldConfiguration.class)
//@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {

}

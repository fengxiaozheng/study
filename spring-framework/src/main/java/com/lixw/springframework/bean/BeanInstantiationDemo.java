package com.lixw.springframework.bean;

import com.lixw.springframework.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lixw
 * @date 2021/03/05
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-instantitation-context.xml");
        User bean = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println("bean = " + bean);
    }
}

package com.lixw.springframework.ioc.dependency.injection;

import com.lixw.springframework.ioc.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lixw
 * @date 2021/03/04
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory =new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        UserRepository bean = beanFactory.getBean(UserRepository.class);
        System.out.println("bean = " + bean);
    }
}

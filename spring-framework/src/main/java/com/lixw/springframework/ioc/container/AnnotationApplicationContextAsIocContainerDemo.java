package com.lixw.springframework.ioc.container;

import com.lixw.springframework.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author lixw
 * @date 2021/03/04
 */
@Configuration
public class AnnotationApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationApplicationContextAsIocContainerDemo.class);
        BeanFactory beanFactory = context.getBeanFactory();
        context.refresh();
        lookupBeanByCollectionType(beanFactory);
    }

    private static void lookupBeanByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, User> beansOfType = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("查找到的所有beansOfType = " + beansOfType);
        }
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("荒");
        return user;
    }
}

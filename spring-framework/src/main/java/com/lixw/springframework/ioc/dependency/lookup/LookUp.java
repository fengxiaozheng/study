package com.lixw.springframework.ioc.dependency.lookup;

import com.lixw.springframework.ioc.dependency.lookup.annotation.Super;
import com.lixw.springframework.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author lixw
 * @date 2021/03/04
 */
public class LookUp {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookupBeanByReal(beanFactory);
        lookupBeanByLazy(beanFactory);
        lookupBeanByType(beanFactory);
        lookupBeanByCollectionType(beanFactory);
        lookupBeanByAnnotation(beanFactory);
    }

    private static void lookupBeanByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, Object> beansWithAnnotation = ((ListableBeanFactory) beanFactory).getBeansWithAnnotation(Super.class);
            System.out.println("根据注解查找到的所有beansWithAnnotation = " + beansWithAnnotation);
        }
    }

    private static void lookupBeanByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, User> beansOfType = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("查找到的所有beansOfType = " + beansOfType);
        }
    }

    private static void lookupBeanByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("根据类型查找user = " + user);
    }

    private static void lookupBeanByLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("根据名称延时查找user = " + user);
    }

    private static void lookupBeanByReal(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("根据名称实时查找user = " + user);
    }
}

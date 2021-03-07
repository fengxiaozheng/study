package com.lixw.springframework.ioc.dependency.lookup;

import com.lixw.springframework.ioc.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.function.Supplier;

/**
 * @author Administrator
 * @Description
 * @Date 2021/3/6
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
        //延迟查找
        lookupByObjectProvider(applicationContext);
        lookupByObjectProviderIfAvailable(applicationContext);
        lookupByStreamOps(applicationContext);
        applicationContext.close();
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        Iterable<String> iterable = applicationContext.getBeanProvider(String.class);
        for (String s : iterable) {
            System.out.println("s = " + s);
        }
    }

    private static void lookupByObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        User available = beanProvider.getIfAvailable(User::createUser);
        System.out.println("available = " + available);
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println("beanProvider.getObject() = " + beanProvider.getObject());
    }

    @Bean
    @Primary
    public String bean1() {
        return "bean1";
    }

    @Bean
    public String bean2() {
        return "bean2";
    }
}

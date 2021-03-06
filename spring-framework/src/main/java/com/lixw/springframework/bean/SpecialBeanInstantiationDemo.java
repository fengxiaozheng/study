package com.lixw.springframework.bean;

import com.lixw.springframework.bean.factory.UserFactory;
import com.lixw.springframework.ioc.domain.User;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author lixw
 * @date 2021/03/05
 */
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {
        displayServiceLoad();
    }

    public static void displayServiceLoad() {
        ServiceLoader<UserFactory> load = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        Iterator<UserFactory> iterator = load.iterator();
        if (iterator.hasNext()) {
            UserFactory user = iterator.next();
            System.out.println("user = " + user.createUser());
        }
    }
}

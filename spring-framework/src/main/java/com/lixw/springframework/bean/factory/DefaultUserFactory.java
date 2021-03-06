package com.lixw.springframework.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lixw
 * @date 2021/03/05
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {


    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct 初始化中");
    }

    public void initUser() {
        System.out.println("自定义 初始化");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 初始化");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy 销毁中 userfactory");
    }


    public void doDestroy() {
        System.out.println("自定义方法销毁bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Disposable 销毁");
    }
}

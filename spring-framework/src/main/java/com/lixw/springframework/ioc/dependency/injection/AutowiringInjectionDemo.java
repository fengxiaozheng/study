package com.lixw.springframework.ioc.dependency.injection;

import com.lixw.springframework.ioc.domain.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author Administrator
 * @description 通过自动注入setter方式实现依赖注入
 * @date 2021/3/6
 */
public class AutowiringInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:/META-INF/autowiring-dependency-injection-context.xml");
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println("userHolder = " + userHolder);
    }
}

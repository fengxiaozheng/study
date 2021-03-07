package com.lixw.springframework.ioc.dependency.injection;

import com.lixw.springframework.ioc.domain.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @description
 * @date 2021/3/6
 */
public class XmlSetterInjectionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String xmlSourcePath = "classpath:/META-INF/dependency-injection-context.xml";
        reader.loadBeanDefinitions(xmlSourcePath);
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println("userHolder = " + userHolder);
    }
}

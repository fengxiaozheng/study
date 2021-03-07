package com.lixw.springframework.ioc.dependency.injection;

import com.lixw.springframework.ioc.domain.UserHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Administrator
 * @description 基于Api实现依赖注入
 * @date 2021/3/6
 */
public class ApiInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //生成userHolder的beanDefinition
        BeanDefinition beanDefinition  = createBeanDefinition();
        //注册userHolder的beanDefinition
        applicationContext.registerBeanDefinition("userHolder", beanDefinition);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        applicationContext.refresh();

        Object userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println("userHolder = " + userHolder);
        applicationContext.close();
    }

    private static BeanDefinition createBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        builder.addPropertyReference("user", "superUser");
        return builder.getBeanDefinition();
    }
}

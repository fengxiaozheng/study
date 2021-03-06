package com.lixw.springframework.ioc.container;

import com.lixw.springframework.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author lixw
 * @date 2021/03/04
 */
public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {
        //创建beanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //加载配置
        int i = reader.loadBeanDefinitions("META-INF/dependency-injection-context.xml");
        System.out.println("读取的bean数量 = " + i);
        lookupBeanByCollectionType(beanFactory);
    }

    private static void lookupBeanByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, User> beansOfType = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("查找到的所有beansOfType = " + beansOfType);
        }
    }
}

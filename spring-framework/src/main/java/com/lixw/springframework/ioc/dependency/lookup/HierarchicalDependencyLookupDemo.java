package com.lixw.springframework.ioc.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 层次性依赖查找
 */
public class HierarchicalDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(HierarchicalDependencyLookupDemo.class);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //1、获取HierarchicalBeanFactory
        System.out.println("当前beanFactory的parent beanFactory：" + beanFactory.getParentBeanFactory());
        //2、设置parent beanFactory
        HierarchicalBeanFactory parentBeanFactory = createBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
        System.out.println("parentBeanFactory = " + beanFactory.getParentBeanFactory());

        displayLocalBean(beanFactory, "user");
        displayLocalBean(parentBeanFactory, "user");

        displayContainsBean(beanFactory, "user");
   //     displayContainsBean(parentBeanFactory, "user");
        context.refresh();
        context.close();
    }

    private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前beanFactory[%s]是否包含bean[%s], %s\n", beanFactory, beanName,
                containsBean(beanFactory, beanName));
    }

    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory) {
            HierarchicalBeanFactory hierarchicalBeanFactory = (HierarchicalBeanFactory) parentBeanFactory;
            if (containsBean(hierarchicalBeanFactory, beanName)) {
                return true;
            }
        }
        return beanFactory.containsBean(beanName);
    }

    private static void displayLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前beanFactory[%s]是否包含local bean[%s], %s\n", beanFactory, beanName,
                beanFactory.containsLocalBean(beanName));
    }
    private static HierarchicalBeanFactory createBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(location);
        return beanFactory;
    }
}

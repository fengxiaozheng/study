package com.lixw.springframework.bean;

import com.lixw.springframework.ioc.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author lixw
 * @date 2021/03/04
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        //1、通过beandefinition来构建
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //通过熟悉设置
        builder.addPropertyValue("id", 1L)
                .addPropertyValue("name", "荒");
        //获取beandefinition
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        //获取beaabsndefinition并非bean的最终状态，可以自定义修改
        
        //2、通过abstractbeandefinition及派生类来实现
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置bean类型
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
//        mutablePropertyValues.addPropertyValue("id", 1L);
//        mutablePropertyValues.addPropertyValue("name", "荒");
        mutablePropertyValues.add("id", 1L)
                .add("name", "荒");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
    }
}

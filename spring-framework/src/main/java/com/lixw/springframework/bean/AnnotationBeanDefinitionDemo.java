package com.lixw.springframework.bean;

import com.lixw.springframework.ioc.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author lixw
 * @date 2021/03/05
 */
//3、通过import方式来导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        //创建beanFactory容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册配置类
        context.register(AnnotationBeanDefinitionDemo.class);

        //1、命名bean的注册方式
        registerBeanDefinition(context, "lixw", User.class);
        //2、非命名bean的注册方式
        registerBeanDefinition(context);

        //启动spring应用上下文
        context.refresh();
        //按照类型依赖查找
        System.out.println("Config类型的所有bean：" + context.getBeansOfType(Config.class));
        System.out.println("user类型的所有bean：" + context.getBeansOfType(User.class));
        //关闭spring上下文
        context.close();
    }


    /**
     *
     * @param registry
     * @param beanName
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        builder.addPropertyValue("id", 1L)
                .addPropertyValue("name", "荒s");

        if (StringUtils.hasText(beanName)) {
            //命名bean的注册方式
            registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
        } else {
            //非命名bean的注册方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
        }

    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry) {
        registerBeanDefinition(registry, null, User.class);
    }

    //2、通过@Component
    @Component//定义当前类作为spring bean（组件）
    public static class Config {

        //1、通过Java注解方式来定义bean
        @Bean
        public User user() {
            User user = new User();
            user.setName("荒");
            user.setId(1L);
            return user;
        }
    }
}

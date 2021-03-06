package com.lixw.springframework.bean;

import com.lixw.springframework.bean.factory.DefaultUserFactory;
import com.lixw.springframework.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author lixw
 * @date 2021/03/05
 */
@Configuration
public class BeanInitDemo {

    public static void main(String[] args) {
        //创建容器
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        //注册配置类
        configApplicationContext.register(BeanInitDemo.class);
        //启动应用上下文
        configApplicationContext.refresh();
        System.out.println("应用上下文已启动");
        //获取bean
        configApplicationContext.getBeansOfType(UserFactory.class);
        //关闭应用上下文
        System.out.println("应用上下文准备关闭");
        configApplicationContext.close();
        System.out.println("应用上下文已关闭");
    }

    @Bean(initMethod = "initUser", destroyMethod = "doDestroy")
    @Lazy
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }

}

package com.lixw.springframework.bean.factory;

import com.lixw.springframework.ioc.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lixw
 * @date 2021/03/05
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}

package com.lixw.springframework.ioc.dependency.repository;

import com.lixw.springframework.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;

import java.util.Collection;

/**
 * @author lixw
 * @date 2021/03/04
 */
public class UserRepository {

    private Collection<User> users;

    private BeanFactory beanFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}

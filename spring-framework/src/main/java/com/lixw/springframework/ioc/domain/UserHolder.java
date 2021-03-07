package com.lixw.springframework.ioc.domain;

/**
 * @author Administrator
 * @description domain
 * @date 2021/3/6
 */
public class UserHolder {

    private User user;

    public UserHolder(User user) {
        this.user = user;
    }

    public UserHolder() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}

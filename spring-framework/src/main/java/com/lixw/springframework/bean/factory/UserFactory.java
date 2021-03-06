package com.lixw.springframework.bean.factory;

import com.lixw.springframework.ioc.domain.User;

/**
 * @author lixw
 * @date 2021/03/05
 */
public interface UserFactory {

    default User createUser() {
        return new User();
    }

    void initUser();

    void doDestroy();
}

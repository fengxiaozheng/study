package com.lixw.springframework.ioc.domain;

import com.lixw.springframework.ioc.dependency.lookup.annotation.Super;

/**
 * @author lixw
 * @date 2021/03/04
 */
@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}

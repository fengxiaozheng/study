package com.lixw.springboot.service;

/**
 * @author lixw
 * @date 2021/02/24
 * 基于配置方式实现自定义条件装配
 */
public interface CalculateService {

    Integer sum(Integer... values);
}

package com.lixw.springboot.service.impl;

import com.lixw.springboot.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author lixw
 * @date 2021/02/24
 */
@Service
@Profile("java8")
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("java8 lambda");
        return Arrays.stream(values).reduce(0, Integer::sum);
    }
}

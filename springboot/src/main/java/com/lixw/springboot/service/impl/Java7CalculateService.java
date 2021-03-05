package com.lixw.springboot.service.impl;

import com.lixw.springboot.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author lixw
 * @date 2021/02/24
 */
@Service
@Profile("java7")
public class Java7CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("java7 for");
        int sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        return sum;
    }
}

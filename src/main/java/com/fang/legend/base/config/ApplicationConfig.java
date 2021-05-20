package com.fang.legend.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SachsFang on 2021/5/19 19:55
 */
@Configuration
public class ApplicationConfig {
    @Bean
    public void test() {
        System.out.println("bean success");
    }
}

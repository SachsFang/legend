package com.fang.legend.addons.injectionTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SachsFang on 2021/10/22 14:22
 */
@Configuration
public class UserConfig {
    @Bean
    public UserService userService1() {
        return new UserService();
    }

    @Bean
    public UserService userService2() {
        return new UserService();
    }
}

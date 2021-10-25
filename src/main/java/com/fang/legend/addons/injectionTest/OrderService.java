package com.fang.legend.addons.injectionTest;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by SachsFang on 2021/10/22 14:32
 */
@Component
public class OrderService {
    //属性注入
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    //构造器注入
//    @Autowired
//    public OrderService(UserService userService) {
//        this.userService = userService;
//    }

//    @Autowired
//    public OrderService(UserService userService, UserService userService1) {
//        System.out.println(userService);
//        System.out.println(userService1);
//        System.out.println(userService2);
//        System.out.println("OrderService两个参数的构造方法执行成功");
//    }
}

package com.fang.legend.addons.injectionTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SachsFang on 2021/10/22 14:21
 */
@Controller
public class UserController {
    @Autowired
    UserService userService1;
}

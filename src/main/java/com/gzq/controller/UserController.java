package com.gzq.controller;
import com.gzq.entity.User;
import com.gzq.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping("login")
    public boolean login(User user){
        System.out.println(user);
       return userService.login(user);

    }
}


package com.yao.oa.controllers;

import com.yao.oa.repositories.UsersRepository;
import com.yao.oa.services.UsersService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 世宁 on 2014/10/3 0003.
 */
@RestController
@RequestMapping("/password")
public class PasswordController {
    @Resource
    private UsersService usersService;
    @RequestMapping("/encode/{password}")
    public String encode(@PathVariable String password) {
        System.out.println(usersService.getPassword("yao"));
        return new BCryptPasswordEncoder().encode(password);
    }
}

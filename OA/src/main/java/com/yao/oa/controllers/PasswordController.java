package com.yao.oa.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 世宁 on 2014/10/3 0003.
 */
@RestController
@RequestMapping("/password")
public class PasswordController {
    @RequestMapping("/encode/{password}")
    public String encode(@PathVariable String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}

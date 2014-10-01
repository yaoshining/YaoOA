package com.yao.util.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author yao
 */
public class PasswordGenerator {
    public static void main(String args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("ys198756"));
    }
}

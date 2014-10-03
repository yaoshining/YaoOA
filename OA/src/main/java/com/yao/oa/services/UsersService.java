package com.yao.oa.services;

import com.yao.oa.domains.Users;
import com.yao.oa.repositories.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 世宁 on 2014/10/4 0004.
 */
@Service
public class UsersService {
    @Resource
    private UsersRepository usersRepository;
    @Transactional
    public String getPassword(String username) {
        Users user =usersRepository.findOne(username);
        return user.getPassword();
    }
}

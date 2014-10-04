package com.yao.oa.services.user.impl;

import com.yao.oa.domains.user.Users;
import com.yao.oa.repositories.user.UsersRepository;
import com.yao.oa.services.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 世宁 on 2014/10/5 0005.
 */
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    @Override
    public Users getUserInfo(String username) {
        return usersRepository.findOne(username);
    }
}

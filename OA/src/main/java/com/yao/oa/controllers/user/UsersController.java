package com.yao.oa.controllers.user;

import com.yao.oa.domains.user.Users;
import com.yao.oa.services.user.UsersService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 世宁 on 2014/10/5 0005.
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Resource
    private UsersService usersService;
    @RequestMapping("/{username}")
    public Users getUserInfo(@PathVariable String username){
        Users user = usersService.getOne(username);
        return user;
    }
}

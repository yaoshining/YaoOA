package com.yao.oa.controllers.user;

import com.yao.oa.domains.user.Users;
import com.yao.oa.services.user.UsersService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 世宁 on 2014/10/5 0005.
 */
@RestController
@RequestMapping(value = {"/users","/services/users"})
public class UsersController {
    @Resource
    private UsersService usersService;
    @RequestMapping(value = "/{username}",method = {RequestMethod.GET},produces = {"application/json"})
    public Users show(@PathVariable String username){
        Users user = usersService.getOne(username);
        return user;
    }
    @RequestMapping(value = "",method = {RequestMethod.GET},produces = {"application/json"})
    public List<Users> index(){
        return usersService.findAll();
    }
}

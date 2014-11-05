package com.yao.oa.services.user;

import com.yao.oa.domains.user.Users;
import com.yao.oa.services.BaseService;
import org.springframework.security.authentication.AuthenticationManager;

/**
 * Created by 世宁 on 2014/10/4 0004.
 */
public interface UsersService extends AuthenticationManager,BaseService<Users, String>{
    public Users getUserInfo(String username);
}

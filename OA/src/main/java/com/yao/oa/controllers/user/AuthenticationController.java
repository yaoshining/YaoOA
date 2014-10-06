package com.yao.oa.controllers.user;

import com.yao.oa.services.user.UsersService;
import net.sf.json.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 世宁 on 2014/10/6 0006.
 */
@RestController
public class AuthenticationController {
    @Resource
    private UsersService usersService;
    @RequestMapping("/login")
    public String login(String username,String password) {
        Authentication request = new UsernamePasswordAuthenticationToken(username,password);
        boolean isAuth = false;
        try {
            Authentication authentication = usersService.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            isAuth = true;
        } catch (AuthenticationException e){
            SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
        }
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("status",isAuth);
        return jsonObj.toString();
    }
}

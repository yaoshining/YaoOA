package com.yao.oa.controllers.user;

import com.yao.oa.services.user.UsersService;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/auth")
public class AuthenticationController {
    @Resource
    private UsersService usersService;
    @RequestMapping(value = "/login",produces = {"application/json"})
    public ResponseEntity<String> login(String username,String password) {
        Authentication request = new UsernamePasswordAuthenticationToken(username,password);
        HttpStatus status = HttpStatus.OK;
        JSONObject jsonObj = new JSONObject();
        try {
            Authentication authentication = usersService.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            status = HttpStatus.OK;
            jsonObj.put("status",true);
            jsonObj.put("principal", authentication.getPrincipal());
        } catch (AuthenticationException e){
//            SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
            jsonObj.put("status",false);
            jsonObj.put("message","Bad Credentials");
        }
        return new ResponseEntity<String>(jsonObj.toString(), status);
    }
    @RequestMapping(value = "/logout")
    public ResponseEntity<Void> logout() {
        SecurityContextHolder.clearContext();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

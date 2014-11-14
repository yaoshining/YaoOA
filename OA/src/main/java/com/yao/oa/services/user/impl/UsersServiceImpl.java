package com.yao.oa.services.user.impl;

import com.yao.oa.domains.user.Users;
import com.yao.oa.repositories.user.UsersRepository;
import com.yao.oa.services.BaseServiceSupport;
import com.yao.oa.services.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by 世宁 on 2014/10/5 0005.
 */
@Service
public class UsersServiceImpl extends BaseServiceSupport<Users, String> implements UsersService {
    private final UsersRepository usersRepository;
    private final UserDetailsService jdbcUserDetailsService;
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository,UserDetailsService jdbcUserDetailsService){
        this.usersRepository = usersRepository;
        this.jdbcUserDetailsService = jdbcUserDetailsService;
    }
    @Override
    public Users getUserInfo(String username) {
        return usersRepository.findOne(username);
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserDetails userDetails = jdbcUserDetailsService.loadUserByUsername(auth.getName());
        if(passwordEncoder.matches(auth.getCredentials().toString(),userDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(auth.getName(),auth.getCredentials(),userDetails.getAuthorities());
        }
        throw new BadCredentialsException("Bad Credentials");
    }

    @Override
    public JpaRepository<Users, String> getJpaRepository() {
        return usersRepository;
    }

    @Override
    public Users getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return findOne(username);
    }
}

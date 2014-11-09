/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.services.demo.impl;

import com.yao.oa.domains.demo.Email;
import com.yao.oa.repositories.demo.EmailRepository;
import com.yao.oa.services.BaseServiceSupport;
import com.yao.oa.services.demo.EmailService;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author yao
 */
@Service
public class EmailServiceImpl extends BaseServiceSupport<Email, Integer> implements EmailService{
    @Resource
    private EmailRepository emailRepository;
    
    @Override
    public JpaRepository<Email, Integer> getJpaRepository() {
        return emailRepository;
    }
    
}

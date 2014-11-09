/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.controllers.demo;

import com.yao.oa.domains.demo.Email;
import com.yao.oa.services.demo.EmailService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yao
 */
@RestController
@RequestMapping("/services/demo/emails")
public class EmailsController {
    @Resource
    private EmailService emailService;
    
    @RequestMapping(value = "",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<List<Email>> index() {
        return new ResponseEntity<List<Email>>(emailService.findAll(),HttpStatus.OK);
    }
    
    @RequestMapping(value = "",method = RequestMethod.POST,produces = {"application/json"})
    public ResponseEntity<Email> create(@RequestBody Email email) {
 //       Email savedEmail = emailService.save(email);
        System.out.println(email.getContent());
        return new ResponseEntity<Email>(email,HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "{id}",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Email> show(@PathVariable Integer id) {
        Email email = emailService.findOne(id);
        return new ResponseEntity<Email>(email,HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}",method = RequestMethod.PUT,produces = {"application/json"})
    public ResponseEntity<Email> update(@PathVariable Integer id,@RequestBody Email email) {
        Email entity = emailService.findOne(id);
        Email updatedEmail = null;
        if(entity!=null){
            updatedEmail = emailService.saveAndFlush(email);
        }
        return new ResponseEntity<Email>(updatedEmail,HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE,produces = {"application/json"})
    public ResponseEntity<Void> destroy(@PathVariable Integer id) {
        emailService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
}

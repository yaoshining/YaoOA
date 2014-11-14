/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.domains.demo;

import com.yao.oa.domains.user.Users;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author yao
 */
@Entity
public class Email implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String subject;
    @Lob
    private String content;
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "senderId")
    private Users sender;
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime = new Date();
    @ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_email",joinColumns = {@JoinColumn(name = "email_id")},inverseJoinColumns = {@JoinColumn(name = "username")})
    private List<Users> receivers;
    @Transient
    private List<String> receiverUserNames;
    @Column
    private Integer[] attachments;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Users getSender() {
        return sender;
    }

    public void setSender(Users sender) {
        this.sender = sender;
    }

    public List<Users> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Users> receivers) {
        this.receivers = receivers;
    }

    public List<String> getReceiverUserNames() {
        return receiverUserNames;
    }

    public void setReceiverUserNames(List<String> receiverUserNames) {
        this.receiverUserNames = receiverUserNames;
    }

    public Integer[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Integer[] attachments) {
        this.attachments = attachments;
    }
    
}

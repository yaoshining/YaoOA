package com.yao.oa.domains.user;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yao.oa.domains.demo.Email;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Created by 世宁 on 2014/10/4 0004.
 */
@Entity
@JsonAutoDetect
public class Users implements Serializable{
    @Id
    private String username;
    private String password;
    private boolean enabled;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY,mappedBy = "sender")
    private List<Email> sendedEmails;
    @JsonIgnore
    @ManyToMany(mappedBy = "receivers",fetch = FetchType.LAZY)
    private List<Email> receivedEmails;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Email> getSendedEmails() {
        return sendedEmails;
    }

    public void setSendedEmails(List<Email> sendedEmails) {
        this.sendedEmails = sendedEmails;
    }

    public List<Email> getReceivedEmails() {
        return receivedEmails;
    }

    public void setReceivedEmails(List<Email> receivedEmails) {
        this.receivedEmails = receivedEmails;
    }
    
    

}

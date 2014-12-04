package com.yao.oa.domains.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.IdClass;

/**
 * Created by 世宁 on 2014/10/4 0004.
 */
@Entity
@IdClass(AuthoritiesPK.class)
public class Authorities implements Serializable{
    @Id
    private String username;
    @Id
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

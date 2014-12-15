/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.domains.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author 世宁
 */
@Embeddable
public class GroupAuthoritiesPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "group_id",nullable = false)
    private Groups group_;
    @Column(nullable = false)
    private String authority;

    public Groups getGroup_() {
        return group_;
    }

    public void setGroup_(Groups group_) {
        this.group_ = group_;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof GroupAuthoritiesPK)) {
            return false;
        }
        GroupAuthoritiesPK pk = (GroupAuthoritiesPK)obj;
        if (!(this.group_ == pk.group_)) return false;
        if (!this.authority.equals(pk.getAuthority())) return false;
        return true;
    }
    @Override
    public int hashCode( )
    {
        return this.group_.hashCode( ) + this.authority.hashCode();
    }
}

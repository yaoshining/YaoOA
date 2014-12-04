/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.domains.user;

import java.io.Serializable;

/**
 *
 * @author yao
 */
public class AuthoritiesPK implements Serializable{
    
    private String username;
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
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof AuthoritiesPK)) {
            return false;
        }
        AuthoritiesPK pk = (AuthoritiesPK)obj;
        if (!this.username.equals(pk.getUsername())) return false;
        if (!this.authority.equals(pk.getAuthority())) return false;
        return true;
   }
   @Override
   public int hashCode( )
   {
      return this.username.hashCode( ) + this.authority.hashCode();
   }
    
}

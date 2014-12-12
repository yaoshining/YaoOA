/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.domains.user;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author 世宁
 */
@Entity
public class GroupAuthorities implements Serializable {
    @EmbeddedId
    private GroupAuthoritiesPK pk;

    public GroupAuthoritiesPK getPk() {
        return pk;
    }

    public void setPk(GroupAuthoritiesPK pk) {
        this.pk = pk;
    }
    
}

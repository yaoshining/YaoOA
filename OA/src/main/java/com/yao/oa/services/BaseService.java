/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.services;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yao
 * @param <T>
 * @param <ID>
 */
public interface BaseService<T extends Object,ID extends Serializable> extends JpaRepository<T, ID> {
    
}

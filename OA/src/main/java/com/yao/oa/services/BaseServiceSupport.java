/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.services;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yao
 * @param <T>
 * @param <ID>
 */
public abstract class BaseServiceSupport<T extends Object,ID extends Serializable> implements BaseService<T, ID>{ 
    public abstract JpaRepository<T,ID> getJpaRepository();
    @Override
    public T findOne(ID id) {
        return getJpaRepository().findOne(id);
    }
    @Override
    public List<T> findAll(){
        return getJpaRepository().findAll();
    }
    @Override
    public List<T> findAll(Sort sort){
        return getJpaRepository().findAll(sort);
    }
    
    @Override
    public List<T> findAll(Iterable<ID> itrbl) {
        return getJpaRepository().findAll(itrbl);
    }
    
    @Override
    public Page<T> findAll(Pageable pgbl) {
        return getJpaRepository().findAll(pgbl);
    }
    @Override
    public <S extends T> S save(S s) {
        return getJpaRepository().save(s);
    }
    @Override
    public <S extends T> List<S> save(Iterable<S> itrbl) {
        return getJpaRepository().save(itrbl);
    }
    
    @Override
    public void flush() {
        getJpaRepository().flush();
    }
    
    @Override
    public <S extends T> S saveAndFlush(S s) {
        return getJpaRepository().saveAndFlush(s);
    }
    @Override
    public void delete(ID id) {
        getJpaRepository().delete(id);
    }
    @Override
    public void delete(T t) {
        getJpaRepository().delete(t);
    }
    
    @Override
    public void delete(Iterable<? extends T> itrbl) {
       getJpaRepository().delete(itrbl);
    }
    @Override
    public void deleteAll() {
        getJpaRepository().deleteAll();
    }
    @Override
    public void deleteInBatch(Iterable<T> itrbl){
        getJpaRepository().deleteInBatch(itrbl);
    }

    @Override
    public void deleteAllInBatch(){
        getJpaRepository().deleteAllInBatch();
    }

    @Override
    public T getOne(ID id){
        return getJpaRepository().findOne(id);
    }
    
    @Override
    public boolean exists(ID id) {
        return getJpaRepository().exists(id);
    }
    
    @Override
    public long count() {
        return getJpaRepository().count();
    }
}

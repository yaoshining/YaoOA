/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.services.demo.impl;

import com.yao.oa.domains.demo.Movie;
import com.yao.oa.repositories.demo.MoviesRepository;
import com.yao.oa.services.BaseServiceSupport;
import com.yao.oa.services.demo.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author yao
 */
@Service
public class MovieServiceImpl extends BaseServiceSupport<Movie, Integer> implements MovieService{
    
    private final MoviesRepository moviesRepository;
    
    @Autowired
    public MovieServiceImpl(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }
    
    @Override
    public JpaRepository<Movie, Integer> getJpaRepository() {
        return moviesRepository;
    }
    
}

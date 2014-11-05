/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.repositories.demo;

import com.yao.oa.domains.demo.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yao
 */
@Repository
public interface MoviesRepository extends JpaRepository<Movie,Integer>{
    
}

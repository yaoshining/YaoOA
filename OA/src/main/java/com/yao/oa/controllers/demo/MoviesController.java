/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yao.oa.controllers.demo;

import com.yao.oa.domains.demo.Movie;
import com.yao.oa.services.demo.MovieService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yao
 */
@RestController
@RequestMapping("/services/demo/movies")
public class MoviesController {
    @Resource
    private MovieService movieService;
    @RequestMapping(value = "",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<List<Movie>> index() {
        List<Movie> resultList = movieService.findAll();
        return new ResponseEntity<List<Movie>>(resultList,HttpStatus.OK);
    }
    
    @RequestMapping(value = "",method = RequestMethod.POST,produces = {"application/json"})
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        Movie savedMovie = movieService.save(movie);
        return new ResponseEntity<Movie>(savedMovie,HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Movie> show(@PathVariable Integer id) {
        Movie movie = movieService.findOne(id);
        return new ResponseEntity<Movie>(movie,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,produces = {"application/json"})
    public ResponseEntity<Movie> update(@PathVariable Integer id,@RequestBody Movie movie) {
        Movie entity = movieService.findOne(id);
        entity.setName(movie.getName());
        movieService.saveAndFlush(entity);
        return new ResponseEntity<Movie>(entity,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE,produces = {"application/json"})
    public ResponseEntity<Void> destroy(@PathVariable Integer id) {
        movieService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

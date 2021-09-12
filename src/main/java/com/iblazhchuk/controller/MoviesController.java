package com.iblazhchuk.controller;

import com.iblazhchuk.model.Movie;
import com.iblazhchuk.service.MoviesService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoviesController {

    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @RequestMapping(path = "/movies")
    @ResponseBody
    public List<Movie> getAllMovies() {
        log.info("request getAll movies in {}", this);
             return moviesService.getAll();
    }

    @RequestMapping(path = "/movies/random")
    @ResponseBody
    public List<Movie> getRandom (@RequestParam (defaultValue = "3") String amount) {
        log.info("request getRandom({}) movies in {}", amount, this);
        return moviesService.getRandom(Integer.parseInt(amount));
    }
}

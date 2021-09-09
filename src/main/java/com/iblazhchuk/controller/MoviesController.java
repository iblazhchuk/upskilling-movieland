package com.iblazhchuk.controller;

import com.iblazhchuk.model.Movie;
import com.iblazhchuk.service.MoviesService;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
public class MoviesController {

    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @RequestMapping(path = "/movies")
    @ResponseBody
    public List<Movie> getAllMovies() {
             return moviesService.getAll();
    }

    @RequestMapping(path = "/movies/random")
    @ResponseBody
    public List<Movie> getRandom (@RequestParam (defaultValue = "3") String amount) {
        return moviesService.getRandom(Integer.parseInt(amount));
    }
}

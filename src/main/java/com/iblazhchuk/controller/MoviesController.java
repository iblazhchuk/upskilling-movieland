package com.iblazhchuk.controller;

import com.iblazhchuk.model.Movie;
import com.iblazhchuk.service.MoviesService;
import com.iblazhchuk.util.JsonJacksonConverter;
import com.iblazhchuk.util.JsonManualConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping( "/api/v1")
public class MoviesController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final MoviesService moviesService;
    private final JsonManualConverter jsonManualConverter;
    private final JsonJacksonConverter jsonJacksonConverter;

    public MoviesController(MoviesService moviesService,
                            JsonManualConverter jsonManualConverter,
                            JsonJacksonConverter jsonJacksonConverter) {
        this.moviesService = moviesService;
        this.jsonManualConverter = jsonManualConverter;
        this.jsonJacksonConverter = jsonJacksonConverter;
    }

    @RequestMapping(path = "/movies", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAllMovies() {
        log.info("Sending request to get all movies");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = moviesService.getAll();
        String moviesJson = jsonManualConverter.toJson(movies);
        log.info("Movies {} is received. It took {} ms", moviesJson, System.currentTimeMillis() - startTime);
        return moviesJson;
    }
}

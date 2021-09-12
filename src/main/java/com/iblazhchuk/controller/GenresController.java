package com.iblazhchuk.controller;

import com.iblazhchuk.model.Genre;
import com.iblazhchuk.service.GenresService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class GenresController {

    private final GenresService genresService;

    public GenresController(GenresService genresService) {
        this.genresService = genresService;
    }

    @RequestMapping(path = "/genres")
    @ResponseBody
    public List<Genre> getAllGenres() {
        log.info("request getAll genres in {}", this);
        return genresService.getAll();
    }


}

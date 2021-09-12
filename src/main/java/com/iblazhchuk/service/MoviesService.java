package com.iblazhchuk.service;

import com.iblazhchuk.dao.MovieDao;
import com.iblazhchuk.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MoviesService {

    private final com.iblazhchuk.dao.MovieDao MovieDao;

    public MoviesService(MovieDao MovieDao) {
        this.MovieDao = MovieDao;
    }

    public List<Movie> getAll() {
        log.info("getAll movies in {}", this);
        return MovieDao.findAll();
    }

    public List<Movie> getRandom (int amount) {
        log.info("getRandom({}) movies in {}", amount, this);
        return MovieDao.getRandom(amount);
    }
}

package com.iblazhchuk.service;

import com.iblazhchuk.dao.MovieDao;
import com.iblazhchuk.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    private final com.iblazhchuk.dao.MovieDao MovieDao;

    public MoviesService(MovieDao MovieDao) {
        this.MovieDao = MovieDao;
    }

    public List<Movie> getAll() {
        return MovieDao.findAll();
    }

    public List<Movie> getRandom (int amount) {

        return MovieDao.getRandom(amount);
    }
}

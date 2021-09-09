package com.iblazhchuk.service;

import com.iblazhchuk.dao.jdbc.JdbcMovieDao;
import com.iblazhchuk.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    private final int MAGIC_AMOUNT_RANDOM_MOVIES = 3;

    private final JdbcMovieDao jdbcMovieDao;

    public MoviesService(JdbcMovieDao jdbcMovieDao) {
        this.jdbcMovieDao = jdbcMovieDao;
    }

    public List<Movie> getAll() {
        return jdbcMovieDao.findAll();
    }

    public List<Movie> getRandom (int amount) {

        return jdbcMovieDao.getRandom(amount);
    }
}

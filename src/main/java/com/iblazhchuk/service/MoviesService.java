package com.iblazhchuk.service;

import com.iblazhchuk.dao.jdbc.JdbcMovieDao;
import com.iblazhchuk.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    private final JdbcMovieDao jdbcMovieDao;

    public MoviesService(JdbcMovieDao jdbcMovieDao) {
        this.jdbcMovieDao = jdbcMovieDao;
    }

    public List<Movie> getAll() {
        return jdbcMovieDao.findAll();
    }
}

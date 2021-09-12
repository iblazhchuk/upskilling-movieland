package com.iblazhchuk.service;

import com.iblazhchuk.dao.MovieDao;
import com.iblazhchuk.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MoviesServiceImpl implements MoviesService {

    private final com.iblazhchuk.dao.MovieDao movieDao;

    public MoviesServiceImpl(MovieDao MovieDao) {
        this.movieDao = MovieDao;
    }

    @Override
    public List<Movie> getAll() {
        log.info("getAll movies in {}", this);
        return movieDao.findAll();
    }

    @Override
    public List<Movie> getRandom (int amount) {
        log.info("getRandom({}) movies in {}", amount, this);
        return movieDao.getRandom(amount);
    }

    @Override
    public List<Movie> getMoviesByGenres(long genreId) {
        return movieDao.findAllByGenre(genreId);
    }
}

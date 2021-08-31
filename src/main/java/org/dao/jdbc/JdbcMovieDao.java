package org.dao.jdbc;

import org.dao.MovieDao;
import org.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcMovieDao implements MovieDao {


    JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Movie findOneById(long id) {
        return null;
    }

    @Override
    public void add(Movie movie) {

    }

    @Override
    public void edit(Movie movie) {

    }

    @Override
    public void removeById(long id) {

    }
}

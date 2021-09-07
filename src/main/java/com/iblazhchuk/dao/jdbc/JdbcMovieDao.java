package com.iblazhchuk.dao.jdbc;

import com.iblazhchuk.dao.MovieDao;
import com.iblazhchuk.dao.jdbc.mapper.MovieRowMapper;
import com.iblazhchuk.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcMovieDao implements MovieDao {

    private static final String FIND_ALL_MOVIES_QUERY =
         "SELECT id, name_russian, name_native, year, rating, price, picture_path from movies";
    private static final String FIND_RANDOM_MOVIES_QUERY =
         "SELECT id, name_russian, name_native, year, rating, price, picture_path from movies order by rand() limit ?";

    private final JdbcTemplate jdbcTemplate;
    private final MovieRowMapper movieRowMapper;

    public JdbcMovieDao(JdbcTemplate jdbcTemplate, MovieRowMapper movie_row_mapper) {
        this.jdbcTemplate = jdbcTemplate;
        movieRowMapper = movie_row_mapper;
    }

    @Override
    public List<Movie> findAll() {
        return jdbcTemplate.query(FIND_ALL_MOVIES_QUERY, movieRowMapper);
    }

    @Override
    public List<Movie> getRandom(int amount) {
        return jdbcTemplate.query(FIND_RANDOM_MOVIES_QUERY, movieRowMapper, amount);
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

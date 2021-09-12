package com.iblazhchuk.dao.jdbc;

import com.iblazhchuk.dao.MovieDao;
import com.iblazhchuk.dao.jdbc.mapper.MovieRowMapper;
import com.iblazhchuk.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
        log.info("findAll movies in {}", this);
        return jdbcTemplate.query(FIND_ALL_MOVIES_QUERY, movieRowMapper);
    }

    @Override
    public List<Movie> getRandom(int amount) {
        log.info("getRandom({}) movies in {}", amount, this);
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

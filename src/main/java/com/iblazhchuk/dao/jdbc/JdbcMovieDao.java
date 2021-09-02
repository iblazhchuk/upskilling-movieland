package com.iblazhchuk.dao.jdbc;

import com.iblazhchuk.dao.MovieDao;
import com.iblazhchuk.dao.jdbc.mapper.MovieRowMapper;
import com.iblazhchuk.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcMovieDao implements MovieDao {


    private static final String FIND_ALL_USERS_QUERY = "SELECT id, name_russian, name_native, years, description, rating, price, picture_path, countries, gentries from movies";
//    private static final String FIND_ONE_USER_BY_USERNAME_QUERY = "SELECT * from users WHERE name = ?";
//    private static final String IS_USER_EXIST_QUERY = "SELECT count(*) FROM users where name = ? AND hash_password = ?";
//    private static final String ADD_USER_QUERY = "INSERT INTO users (name, role, hash_password, salt) values (?, ?, ?, ?)";
//    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE name = ? AND hash_password = ? AND role = ?";
//    private static final String UPDATE_USER_QUERY = "UPDATE users SET hash_password = ?, salt = ?, role = ?  WHERE name = ?";


    private final JdbcTemplate jdbcTemplate;
    private final MovieRowMapper movieRowMapper;


    public JdbcMovieDao(JdbcTemplate jdbcTemplate, MovieRowMapper movie_row_mapper) {
        this.jdbcTemplate = jdbcTemplate;
        movieRowMapper = movie_row_mapper;
    }

    @Override
    public List<Movie> findAll() {

        return jdbcTemplate.query(FIND_ALL_USERS_QUERY, movieRowMapper);
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

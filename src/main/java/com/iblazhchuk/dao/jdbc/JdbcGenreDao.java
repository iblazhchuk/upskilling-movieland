package com.iblazhchuk.dao.jdbc;

import com.iblazhchuk.dao.GenreDao;
import com.iblazhchuk.dao.jdbc.mapper.GenreRowMapper;
import com.iblazhchuk.model.Genre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JdbcGenreDao implements GenreDao {

    private static final String FIND_ALL_GENRES_QUERY = "SELECT id, genre_name from genres";

    private final JdbcTemplate jdbcTemplate;
    private final GenreRowMapper genreRowMapper;

    public JdbcGenreDao(JdbcTemplate jdbcTemplate, GenreRowMapper genreRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.genreRowMapper = genreRowMapper;
    }

    @Override
    public List<Genre> findAll() {
        return jdbcTemplate.query(FIND_ALL_GENRES_QUERY, genreRowMapper);
    }
}

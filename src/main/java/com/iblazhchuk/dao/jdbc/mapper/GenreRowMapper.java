package com.iblazhchuk.dao.jdbc.mapper;

import com.iblazhchuk.model.Genre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Slf4j
public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        log.info("Mapping genre {} in {}", resultSet.getString("genre_name"), this);

        return new Genre(
                resultSet.getLong("id"),
                resultSet.getString("genre_name")
        );
    }
}

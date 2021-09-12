package com.iblazhchuk.dao.jdbc.mapper;

import com.iblazhchuk.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Slf4j
public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        log.info("Mapping movie {} in {}", resultSet.getString("name_native"), this);
        return new Movie(
                resultSet.getLong("id"),
                resultSet.getString("name_russian"),
                resultSet.getString("name_native"),
                resultSet.getDate("year").toLocalDate(),
                resultSet.getDouble("rating"),
                resultSet.getDouble("price"),
                resultSet.getString("picture_path")
        );
    }
}

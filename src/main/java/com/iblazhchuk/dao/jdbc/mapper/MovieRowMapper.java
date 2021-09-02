package com.iblazhchuk.dao.jdbc.mapper;

import com.iblazhchuk.model.Movie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Movie(
                resultSet.getLong("id"),
                resultSet.getString("nameRussian"),
                resultSet.getString("nameNative"),
                resultSet.getDate("year").toLocalDate(),
                resultSet.getString("description"),
                resultSet.getDouble("rating"),
                resultSet.getDouble("rapriceting"),
                resultSet.getString("picturePath"),
                resultSet.getString("countries"),
                resultSet.getString("gentries")
        );
    }
}

package com.iblazhchuk.dao.jdbc.mapper;

import com.iblazhchuk.model.Movie;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovieRowMapperTest {

    @Test
    void testMovieMapRow() throws SQLException {

        MovieRowMapper movieRowMapper = new MovieRowMapper();
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getLong("id")).thenReturn(1L);
        when(resultSet.getString("name_russian")).thenReturn("Побег из Шоушенка");
        when(resultSet.getString("name_native")).thenReturn("The Shawshank Redemption");
        when(resultSet.getDate("year")).thenReturn(Date.valueOf("1994-01-01"));
        when(resultSet.getDouble("rating")).thenReturn(8.90);
        when(resultSet.getDouble("price")).thenReturn(123.45);
        when(resultSet.getString("picture_path")).thenReturn("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg");

        Movie expectedMovie = new Movie(1L, "Побег из Шоушенка", "The Shawshank Redemption",
                LocalDate.of(1994,1,1), 8.90, 123.45,
                "https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg"
        );

        Movie actualMovie = movieRowMapper.mapRow(resultSet, 0);

        assertEquals(expectedMovie, actualMovie);
    }
}
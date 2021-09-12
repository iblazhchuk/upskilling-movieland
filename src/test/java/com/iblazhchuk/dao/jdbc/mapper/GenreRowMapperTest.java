package com.iblazhchuk.dao.jdbc.mapper;

import com.iblazhchuk.model.Genre;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GenreRowMapperTest {

    @Test
    void testMapRow() throws SQLException {
        GenreRowMapper genreRowMapper = new GenreRowMapper();
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getLong("id")).thenReturn(1L);
        when(resultSet.getString("genre_name")).thenReturn("драма");

        Genre expectedGenre = new Genre(1, "драма");

        assertEquals(expectedGenre, genreRowMapper.mapRow(resultSet, 0));
    }
}
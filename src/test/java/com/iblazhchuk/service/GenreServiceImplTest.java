package com.iblazhchuk.service;

import com.iblazhchuk.dao.jdbc.JdbcGenreDao;
import com.iblazhchuk.model.Genre;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GenreServiceImplTest {
    Genre dramaGenre = new Genre(1, "драма");
    Genre crimeGenre = new Genre(2, "криминал");
    Genre fantasyGenre = new Genre(3, "фэнтези");

    List<Genre> genresList = new ArrayList<>();

    @Test
    void testGetAllGenres() {

        genresList.add(dramaGenre);
        genresList.add(crimeGenre);
        genresList.add(fantasyGenre);

        JdbcGenreDao jdbcGenreDao = mock(JdbcGenreDao.class);
        when(jdbcGenreDao.findAll()).thenReturn(genresList);

        GenresService genresService = new GenreServiceImpl(jdbcGenreDao);

        assertEquals(genresList, genresService.getAll() );
    }
}
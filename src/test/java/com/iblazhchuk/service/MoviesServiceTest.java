package com.iblazhchuk.service;

import com.iblazhchuk.dao.jdbc.JdbcMovieDao;
import com.iblazhchuk.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MoviesServiceTest {
    List<Movie> expectedMovies = new ArrayList<>();

    @BeforeEach
    void setUp() {

        Movie movie1 = new Movie(
                1L, "Звёздные войны: Эпизод 5 – Империя наносит ответный удар",
                "Star Wars: Episode V - The Empire Strikes Back",
                LocalDate.of(1980,1, 1), 8.2, 198.98,
                "https://images201.jpg"
        );

        Movie movie2 = new Movie(
                2L, "Титаник", "Titanic",
                LocalDate.of(1997,1, 1), 7.9, 150.00,
                "https://images202.jpg"
        );

        Movie movie3 = new Movie(
                3L, "Гладиатор","Gladiator",
                LocalDate.of(2000,1, 1), 8.6, 175.00,
                "https://images203.jpg"
        );

        Movie movie4 = new Movie(
                4L, "Зеленая миля", "The Green Mile",
                LocalDate.of(1999,1, 1), 8.9, 134.67,
                "https://images204.jpg"
        );
        Movie movie5 = new Movie(
                5L, "Начало", "Inception",
                LocalDate.of(2010,1, 1), 8.6, 130.00,
                "https://images204.jpg"
        );
        expectedMovies.clear();
        expectedMovies.add(movie1);
        expectedMovies.add(movie2);
        expectedMovies.add(movie3);
        expectedMovies.add(movie4);
        expectedMovies.add(movie5);
    }

    @Test
    void testGetAll() {
        JdbcMovieDao jdbcMovieDao = mock(JdbcMovieDao.class);
        when(jdbcMovieDao.findAll()).thenReturn(expectedMovies);

        MoviesService moviesService = new MoviesService(jdbcMovieDao);
        assertEquals(expectedMovies, moviesService.getAll());
    }

    @Test
    void testGetRandom() {

        JdbcMovieDao jdbcMovieDao = mock(JdbcMovieDao.class);
        when(jdbcMovieDao.getRandom(5)).thenReturn(expectedMovies);

        MoviesService moviesService = new MoviesService(jdbcMovieDao);
        assertEquals(expectedMovies, moviesService.getRandom(5));
    }
}
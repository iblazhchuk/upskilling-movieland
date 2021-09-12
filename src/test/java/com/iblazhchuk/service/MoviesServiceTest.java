package com.iblazhchuk.service;

import com.iblazhchuk.dao.jdbc.JdbcMovieDao;
import com.iblazhchuk.model.Movie;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MoviesServiceTest {
    List<Movie> expectedMovies = new ArrayList<>();

    Movie movieStarWarsV = new Movie(
            1L, "Звёздные войны: Эпизод 5 – Империя наносит ответный удар",
            "Star Wars: Episode V - The Empire Strikes Back",
            LocalDate.of(1980,1, 1), 8.2, 198.98,
            "https://images201.jpg");

    Movie movieTitanic = new Movie(
            2L, "Титаник", "Titanic",
            LocalDate.of(1997,1, 1), 7.9, 150.00,
            "https://images202.jpg");

    Movie movieGladiator = new Movie(
            3L, "Гладиатор","Gladiator",
            LocalDate.of(2000,1, 1), 8.6, 175.00,
            "https://images203.jpg");

    Movie movieTheGreenMile = new Movie(
            4L, "Зеленая миля", "The Green Mile",
            LocalDate.of(1999,1, 1), 8.9, 134.67,
            "https://images204.jpg");

    Movie movieInception = new Movie(
            5L, "Начало", "Inception",
            LocalDate.of(2010,1, 1), 8.6, 130.00,
            "https://images205.jpg"
    );

    @Test
    void testGetAll() {

        expectedMovies.add(movieStarWarsV);
        expectedMovies.add(movieTitanic);
        expectedMovies.add(movieGladiator);
        expectedMovies.add(movieTheGreenMile);
        expectedMovies.add(movieInception);

        JdbcMovieDao jdbcMovieDao = mock(JdbcMovieDao.class);
        when(jdbcMovieDao.findAll()).thenReturn(expectedMovies);

        MoviesService moviesService = new MoviesService(jdbcMovieDao);
        assertEquals(expectedMovies, moviesService.getAll());
    }

    @Test
    void testGetRandom() {

        expectedMovies.add(movieTitanic);
        expectedMovies.add(movieGladiator);
        expectedMovies.add(movieTheGreenMile);

        JdbcMovieDao jdbcMovieDao = mock(JdbcMovieDao.class);
        when(jdbcMovieDao.getRandom(3)).thenReturn(expectedMovies);

        MoviesService moviesService = new MoviesService(jdbcMovieDao);
        assertEquals(expectedMovies, moviesService.getRandom(3));
    }
}
package com.iblazhchuk.controller;

import com.iblazhchuk.model.Movie;
import com.iblazhchuk.service.MoviesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MoviesControllerTest {

    private MockMvc mockMvc;
    private MoviesServiceImpl moviesService;

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

    @BeforeEach
    void setUp() {
        this.moviesService = mock(MoviesServiceImpl.class);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MoviesController(moviesService)).build();
    }

    @Test
    void testGetAllMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies.add(movieStarWarsV);
        movies.add(movieTitanic);
        movies.add(movieGladiator);
        movies.add(movieTheGreenMile);
        movies.add(movieInception);

        when(moviesService.getAll()).thenReturn(movies);

        this.mockMvc.perform(get("/api/v1/movies").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nameRussian").value("Звёздные войны: Эпизод 5 – Империя наносит ответный удар"))
                .andExpect(jsonPath("$[0].nameNative").value("Star Wars: Episode V - The Empire Strikes Back"))
                .andExpect(jsonPath("$[0].year").value("1980"))
                .andExpect(jsonPath("$[0].rating").value("8.2"))
                .andExpect(jsonPath("$[0].price").value("198.98"))
                .andExpect(jsonPath("$[0].picturePath").value("https://images201.jpg"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nameRussian").value("Титаник"))
                .andExpect(jsonPath("$[1].nameNative").value("Titanic"))
                .andExpect(jsonPath("$[1].year").value("1997"))
                .andExpect(jsonPath("$[1].rating").value("7.9"))
                .andExpect(jsonPath("$[1].price").value("150.0"))
                .andExpect(jsonPath("$[1].picturePath").value("https://images202.jpg"))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].nameRussian").value("Гладиатор"))
                .andExpect(jsonPath("$[2].nameNative").value("Gladiator"))
                .andExpect(jsonPath("$[2].year").value("2000"))
                .andExpect(jsonPath("$[2].rating").value("8.6"))
                .andExpect(jsonPath("$[2].price").value("175.0"))
                .andExpect(jsonPath("$[2].picturePath").value("https://images203.jpg"))
                .andExpect(jsonPath("$[3].id").value(4))
                .andExpect(jsonPath("$[3].nameRussian").value("Зеленая миля"))
                .andExpect(jsonPath("$[3].nameNative").value("The Green Mile"))
                .andExpect(jsonPath("$[3].year").value("1999"))
                .andExpect(jsonPath("$[3].rating").value("8.9"))
                .andExpect(jsonPath("$[3].price").value("134.67"))
                .andExpect(jsonPath("$[3].picturePath").value("https://images204.jpg"))
                .andExpect(jsonPath("$[4].id").value(5))
                .andExpect(jsonPath("$[4].nameRussian").value("Начало"))
                .andExpect(jsonPath("$[4].nameNative").value("Inception"))
                .andExpect(jsonPath("$[4].year").value("2010"))
                .andExpect(jsonPath("$[4].rating").value("8.6"))
                .andExpect(jsonPath("$[4].price").value("130.0"))
                .andExpect(jsonPath("$[4].picturePath").value("https://images205.jpg"))
        ;
        verify(moviesService, times(1)).getAll();
        verifyNoMoreInteractions(moviesService);

    }

    @Test
    void testGetRandomWithValue() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies.add(movieTitanic);
        movies.add(movieGladiator);
        movies.add(movieTheGreenMile);
        movies.add(movieInception);

        when(moviesService.getRandom(4)).thenReturn(movies);

        this.mockMvc.perform(get("/api/v1/movies/random/?amount=4").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].nameRussian").value("Титаник"))
                .andExpect(jsonPath("$[0].nameNative").value("Titanic"))
                .andExpect(jsonPath("$[0].year").value("1997"))
                .andExpect(jsonPath("$[0].rating").value("7.9"))
                .andExpect(jsonPath("$[0].price").value("150.0"))
                .andExpect(jsonPath("$[0].picturePath").value("https://images202.jpg"))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].nameRussian").value("Гладиатор"))
                .andExpect(jsonPath("$[1].nameNative").value("Gladiator"))
                .andExpect(jsonPath("$[1].year").value("2000"))
                .andExpect(jsonPath("$[1].rating").value("8.6"))
                .andExpect(jsonPath("$[1].price").value("175.0"))
                .andExpect(jsonPath("$[1].picturePath").value("https://images203.jpg"))
                .andExpect(jsonPath("$[2].id").value(4))
                .andExpect(jsonPath("$[2].nameRussian").value("Зеленая миля"))
                .andExpect(jsonPath("$[2].nameNative").value("The Green Mile"))
                .andExpect(jsonPath("$[2].year").value("1999"))
                .andExpect(jsonPath("$[2].rating").value("8.9"))
                .andExpect(jsonPath("$[2].price").value("134.67"))
                .andExpect(jsonPath("$[2].picturePath").value("https://images204.jpg"))
                .andExpect(jsonPath("$[3].id").value(5))
                .andExpect(jsonPath("$[3].nameRussian").value("Начало"))
                .andExpect(jsonPath("$[3].nameNative").value("Inception"))
                .andExpect(jsonPath("$[3].year").value("2010"))
                .andExpect(jsonPath("$[3].rating").value("8.6"))
                .andExpect(jsonPath("$[3].price").value("130.0"))
                .andExpect(jsonPath("$[3].picturePath").value("https://images205.jpg"))
        ;
        verify(moviesService, times(1)).getRandom(4);
        verifyNoMoreInteractions(moviesService);
    }

    @Test
    void testGetRandomWithOutValue() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies.add(movieTitanic);
        movies.add(movieGladiator);
        movies.add(movieTheGreenMile);

        when(moviesService.getRandom(3)).thenReturn(movies);

        this.mockMvc.perform(get("/api/v1/movies/random").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].nameRussian").value("Титаник"))
                .andExpect(jsonPath("$[0].nameNative").value("Titanic"))
                .andExpect(jsonPath("$[0].year").value("1997"))
                .andExpect(jsonPath("$[0].rating").value("7.9"))
                .andExpect(jsonPath("$[0].price").value("150.0"))
                .andExpect(jsonPath("$[0].picturePath").value("https://images202.jpg"))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].nameRussian").value("Гладиатор"))
                .andExpect(jsonPath("$[1].nameNative").value("Gladiator"))
                .andExpect(jsonPath("$[1].year").value("2000"))
                .andExpect(jsonPath("$[1].rating").value("8.6"))
                .andExpect(jsonPath("$[1].price").value("175.0"))
                .andExpect(jsonPath("$[1].picturePath").value("https://images203.jpg"))
                .andExpect(jsonPath("$[2].id").value(4))
                .andExpect(jsonPath("$[2].nameRussian").value("Зеленая миля"))
                .andExpect(jsonPath("$[2].nameNative").value("The Green Mile"))
                .andExpect(jsonPath("$[2].year").value("1999"))
                .andExpect(jsonPath("$[2].rating").value("8.9"))
                .andExpect(jsonPath("$[2].price").value("134.67"))
                .andExpect(jsonPath("$[2].picturePath").value("https://images204.jpg"))
        ;
        verify(moviesService, times(1)).getRandom(3);
        verifyNoMoreInteractions(moviesService);
    }

    @Test
    void testGetMoviesByGenreId() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies.add(movieTitanic);
        movies.add(movieGladiator);
        movies.add(movieTheGreenMile);

        when(moviesService.getMoviesByGenres(1)).thenReturn(movies);

        this.mockMvc.perform(get("/api/v1/movies/genre/1").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].nameRussian").value("Титаник"))
                .andExpect(jsonPath("$[0].nameNative").value("Titanic"))
                .andExpect(jsonPath("$[0].year").value("1997"))
                .andExpect(jsonPath("$[0].rating").value("7.9"))
                .andExpect(jsonPath("$[0].price").value("150.0"))
                .andExpect(jsonPath("$[0].picturePath").value("https://images202.jpg"))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].nameRussian").value("Гладиатор"))
                .andExpect(jsonPath("$[1].nameNative").value("Gladiator"))
                .andExpect(jsonPath("$[1].year").value("2000"))
                .andExpect(jsonPath("$[1].rating").value("8.6"))
                .andExpect(jsonPath("$[1].price").value("175.0"))
                .andExpect(jsonPath("$[1].picturePath").value("https://images203.jpg"))
                .andExpect(jsonPath("$[2].id").value(4))
                .andExpect(jsonPath("$[2].nameRussian").value("Зеленая миля"))
                .andExpect(jsonPath("$[2].nameNative").value("The Green Mile"))
                .andExpect(jsonPath("$[2].year").value("1999"))
                .andExpect(jsonPath("$[2].rating").value("8.9"))
                .andExpect(jsonPath("$[2].price").value("134.67"))
                .andExpect(jsonPath("$[2].picturePath").value("https://images204.jpg"))
        ;
        verify(moviesService, times(1)).getMoviesByGenres(1);
        verifyNoMoreInteractions(moviesService);
    }


}
package com.iblazhchuk.controller;

import com.iblazhchuk.model.Genre;
import com.iblazhchuk.service.GenresService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GenresControllerTest {

    private MockMvc mockMvc;
    private GenresService genresService;

    Genre dramaGenre = new Genre(1, "драма");
    Genre crimeGenre = new Genre(2, "криминал");
    Genre fantasyGenre = new Genre(3, "фэнтези");

    List<Genre> genresList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        genresService = mock(GenresService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new GenresController(genresService)).build();
    }

    @Test
    void testGetAllGenres() throws Exception {
        genresList.add(dramaGenre);
        genresList.add(crimeGenre);
        genresList.add(fantasyGenre);

        when(genresService.getAll()).thenReturn(genresList);

        this.mockMvc.perform(get("/api/v1/genres").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].genreName").value("драма"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].genreName").value("криминал"))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].genreName").value("фэнтези"));

        verify(genresService, times(1)).getAll();
        verifyNoMoreInteractions(genresService);
    }
}
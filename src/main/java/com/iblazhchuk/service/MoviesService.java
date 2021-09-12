package com.iblazhchuk.service;

import com.iblazhchuk.model.Movie;

import java.util.List;

public interface MoviesService {

    List<Movie> getAll();

    List<Movie> getRandom (int amount);

    List<Movie> getMoviesByGenres (long genreId);

}

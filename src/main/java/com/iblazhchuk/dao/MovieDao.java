package com.iblazhchuk.dao;

import com.iblazhchuk.model.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> findAll();

    List<Movie> getRandom(int amount);

    List<Movie> findAllByGenre(long genreId);
}

package org.dao;

import org.model.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> findAll();

    Movie findOneById (long id);

    void add(Movie movie);

    void edit (Movie movie);

    void removeById (long id);
}

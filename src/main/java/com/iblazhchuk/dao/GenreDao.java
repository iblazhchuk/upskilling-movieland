package com.iblazhchuk.dao;

import com.iblazhchuk.model.Genre;

import java.util.List;

public interface GenreDao {

    List<Genre> findAll();

}

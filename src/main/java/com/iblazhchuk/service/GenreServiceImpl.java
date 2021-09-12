package com.iblazhchuk.service;

import com.iblazhchuk.dao.GenreDao;
import com.iblazhchuk.model.Genre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GenreServiceImpl implements GenresService{

    private final GenreDao genreDao;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.findAll();
    }
}

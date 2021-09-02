package com.iblazhchuk.dao.jdbc;

import com.iblazhchuk.dao.ReviewDao;
import com.iblazhchuk.model.Review;

import java.util.List;

public class JdbcReviewDao implements ReviewDao {
    @Override
    public List<Review> findAll() {
        return null;
    }

    @Override
    public Review findOneById(long id) {
        return null;
    }

    @Override
    public void add(Review review) {

    }

    @Override
    public void edit(Review review) {

    }

    @Override
    public void removeById(long id) {

    }
}

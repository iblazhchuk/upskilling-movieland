package com.iblazhchuk.dao;


import com.iblazhchuk.model.Review;

import java.util.List;

public interface ReviewDao {

    List<Review> findAll();

    Review findOneById(long id);

    void add(Review review);

    void edit (Review review);

    void removeById (long id);

}

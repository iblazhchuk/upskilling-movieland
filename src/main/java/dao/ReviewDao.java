package dao;

import model.Movie;


import java.util.List;

public interface ReviewDao {

    List<Review> findAll();

    Review findOneById(long id);

    void add(Review review);

    void edit (Review review);

    void removeById (long id);

}

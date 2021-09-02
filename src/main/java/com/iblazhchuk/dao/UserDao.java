package com.iblazhchuk.dao;

import com.iblazhchuk.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findOneById(long id);

    void add(User user);

    void edit (User user);

    void removeById (long id);
}

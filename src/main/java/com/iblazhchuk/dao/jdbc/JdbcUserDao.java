package com.iblazhchuk.dao.jdbc;

import com.iblazhchuk.dao.UserDao;
import com.iblazhchuk.model.User;

import java.util.List;

public class JdbcUserDao implements UserDao {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findOneById(long id) {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void removeById(long id) {

    }
}

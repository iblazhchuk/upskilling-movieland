package org.dao.jdbc;

import org.dao.UserDao;
import org.model.User;

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

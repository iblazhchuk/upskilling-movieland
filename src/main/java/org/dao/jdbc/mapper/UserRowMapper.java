package org.dao.jdbc.mapper;

import org.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper <User>{
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        return new User(
        resultSet.getLong("id"),
        resultSet.getString("firstName"),
        resultSet.getString("lastName"),
        resultSet.getString("email"),
        resultSet.getString("role"),
        resultSet.getString("hashPassword"),
        resultSet.getString("salt")
        );

    }
}

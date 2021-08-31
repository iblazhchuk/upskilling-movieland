package dao.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper <User>{
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();
        return null;
    }
}

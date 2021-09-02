package com.iblazhchuk.dao.jdbc.mapper;

import com.iblazhchuk.model.Review;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {


    @Override
    public Review mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Review(
                resultSet.getLong("id"),
                resultSet.getLong("filmId"),
                resultSet.getLong("userId"),
                resultSet.getString("textReview")
        );
    }
}

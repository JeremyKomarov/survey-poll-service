package com.pollService.repository.mapper;

import com.pollService.model.response.QuestionCountResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionCountMapper implements RowMapper<QuestionCountResponse> {
    @Override
    public QuestionCountResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new QuestionCountResponse(
                rs.getString("question"),
                rs.getLong("user_answered")
        );
    }
}

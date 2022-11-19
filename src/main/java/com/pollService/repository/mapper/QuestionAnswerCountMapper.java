package com.pollService.repository.mapper;

import com.pollService.model.response.QuestionAnswerCountResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionAnswerCountMapper implements RowMapper<QuestionAnswerCountResponse> {

    @Override
    public QuestionAnswerCountResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new QuestionAnswerCountResponse(
                rs.getString("question"),
                rs.getString("answer"),
                rs.getLong("user_answered")
        );
    }
}

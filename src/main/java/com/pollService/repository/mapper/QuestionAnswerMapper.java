package com.pollService.repository.mapper;

import com.pollService.model.QuestionAnswerResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionAnswerMapper implements RowMapper<QuestionAnswerResponse> {
    @Override
    public QuestionAnswerResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new QuestionAnswerResponse(
                rs.getString("question"),
                rs.getString("answer")
        );
    }
}

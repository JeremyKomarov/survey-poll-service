package com.pollService.repository.mapper;

import com.pollService.model.Answer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerMapper implements RowMapper<Answer> {

    @Override
    public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Answer(
                rs.getLong("id"),
                rs.getLong("q_id"),
                rs.getString("answer")
        );
    }
}

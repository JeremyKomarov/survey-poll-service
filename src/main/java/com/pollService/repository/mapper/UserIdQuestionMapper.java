package com.pollService.repository.mapper;

import com.pollService.model.UserIdQuestionResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserIdQuestionMapper implements RowMapper<UserIdQuestionResponse> {
    @Override
    public UserIdQuestionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserIdQuestionResponse(
                rs.getLong("user_id"),
                rs.getLong("question_answered")
        );
    }
}

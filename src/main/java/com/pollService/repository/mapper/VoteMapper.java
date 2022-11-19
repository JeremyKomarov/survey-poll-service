package com.pollService.repository.mapper;

import com.pollService.model.Vote;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteMapper implements RowMapper<Vote> {

    @Override
    public Vote mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Vote(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("question_id"),
                rs.getLong("answer_id")
        );
    }
}

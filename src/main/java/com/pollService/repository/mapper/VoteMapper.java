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
                rs.getLong("userId"),
                rs.getLong("questionId"),
                rs.getLong("answerId")
        );
    }
}

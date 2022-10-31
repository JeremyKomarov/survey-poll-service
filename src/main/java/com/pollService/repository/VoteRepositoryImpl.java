package com.pollService.repository;
import com.pollService.model.Vote;
import com.pollService.repository.mapper.QuestionMapper;
import com.pollService.repository.mapper.VoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoteRepositoryImpl implements VoteRepository {

    private static final String VOTE_TABLE_NAME = "vote";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createVote(Vote vote) {
        String sql = "INSERT INTO " + VOTE_TABLE_NAME + " (question_id ,answer_id ) VALUES (?,?)";
        jdbcTemplate.update(sql, vote.getQuestionId(), vote.getAnswerId());
    }


    @Override
    public Vote getVoteById(Long id) {
        String sql = "SELECT * FROM " + VOTE_TABLE_NAME + " WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new VoteMapper(), id);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public void updateVoteById(Long id, Vote vote) {
        String sql = "UPDATE " + VOTE_TABLE_NAME + " SET question_id=?, answer_id=? " + "WHERE id=?";
        jdbcTemplate.update(sql, vote.getQuestionId(),vote.getAnswerId(), id);
    }

    @Override
    public void deleteVoteById(Long id) {
        String sql = "DELETE FROM " + VOTE_TABLE_NAME + " WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }


    @Override
    public List<Long> getQuestionCountByQuestionId(Long questionId){
        String sql = "SELECT COUNT(answer_id) FROM " + VOTE_TABLE_NAME + " WHERE question_id = ?";
        try {
            return jdbcTemplate.queryForList(sql, Long.class, questionId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }


}





//    SELECT COUNT(rating)
//    FROM movie_details
//    WHERE rating = 8
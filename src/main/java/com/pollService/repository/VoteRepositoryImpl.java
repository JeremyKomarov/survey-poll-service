package com.pollService.repository;
import com.pollService.model.*;
import com.pollService.model.response.QuestionAnswerCountResponse;
import com.pollService.model.response.QuestionAnswerResponse;
import com.pollService.model.response.QuestionCountResponse;
import com.pollService.model.response.UserIdQuestionResponse;
import com.pollService.repository.mapper.*;
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
        String sql = "INSERT INTO " + VOTE_TABLE_NAME + " (user_id, question_id ,answer_id ) VALUES (? ,? ,?)";
        jdbcTemplate.update(sql,vote.getUserId(), vote.getQuestionId(), vote.getAnswerId());
    }

    @Override
    public Vote getVoteById(Long id) {
        String sql = "SELECT * FROM " + VOTE_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new VoteMapper(), id);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public void updateVoteById(Long id, Vote vote) {
        String sql = "UPDATE " + VOTE_TABLE_NAME + " SET user_id=?, question_id=?, answer_id=? " + "WHERE id=?";
        jdbcTemplate.update(sql,vote.getUserId(), vote.getQuestionId(),vote.getAnswerId(), id);
    }

    @Override
    public void deleteVoteById(Long id) {
        String sql = "DELETE FROM " + VOTE_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void deleteAllVotesByUserId(Long userId) {
        String sql = "DELETE FROM " + VOTE_TABLE_NAME + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public List<QuestionAnswerCountResponse> getTotalAnsweredQuestionCountByQuestionId(Long questionId) {
        String sql = "SELECT question.question, answer.answer, COUNT(user_id) as user_answered FROM " + VOTE_TABLE_NAME + " INNER JOIN question ON vote.question_id = question.id INNER JOIN answer ON vote.answer_id = answer.id WHERE question_id=? GROUP BY question_id, answer_id";
        return jdbcTemplate.query(sql, new QuestionAnswerCountMapper(), questionId);
    }

    @Override
    public QuestionCountResponse getTotalChosenQuestionByQuestionId(Long questionId) {
        String sql = "SELECT question.question, COUNT(user_id) as user_answered FROM " + VOTE_TABLE_NAME + " INNER JOIN question ON vote.question_id = question.id WHERE question_id=? GROUP BY question_id";
        return jdbcTemplate.queryForObject(sql, new QuestionCountMapper(), questionId);
    }

    public List<QuestionAnswerResponse> getUserQuestionOptionsByUserId(Long userId) {
        String sql = "SELECT question.question, answer.answer FROM " + VOTE_TABLE_NAME + " INNER JOIN question ON vote.question_id = question.id INNER JOIN answer ON vote.answer_id = answer.id WHERE user_id=?";
        return jdbcTemplate.query(sql, new QuestionAnswerMapper(), userId);
    }

    @Override
    public UserIdQuestionResponse getTotalUserQuestionsCount(Long userId) {
        String sql = "SELECT user_id, COUNT(question_id) AS question_answered FROM " + VOTE_TABLE_NAME + " WHERE user_id=? GROUP BY user_id";
        return jdbcTemplate.queryForObject(sql, new UserIdQuestionMapper(), userId);
    }

    @Override
    public List<QuestionAnswerCountResponse> getAllQuestionAnswers() {
        String sql = "SELECT question.question, answer.answer, COUNT(answer) AS user_answered FROM " + VOTE_TABLE_NAME + " INNER JOIN question ON vote.question_id=question.id INNER JOIN answer ON vote.answer_id = answer.id GROUP BY question_id, answer ORDER BY question_id ASC";
        return jdbcTemplate.query(sql, new QuestionAnswerCountMapper());
    }
}



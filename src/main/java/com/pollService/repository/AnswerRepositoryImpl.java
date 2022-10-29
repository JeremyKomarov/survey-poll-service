package com.pollService.repository;

import com.pollService.model.Answer;
import com.pollService.repository.mapper.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository {

    private static final String ANSWER_TABLE_NAME = "answer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createAnswer(Answer answer) {
        String sql = "INSERT INTO " + ANSWER_TABLE_NAME + " (question_id, answer) VALUES (?, ?)";
        jdbcTemplate.update(sql, answer.getQuestionId(), answer.getAnswerContent());
    }

    @Override
    public Answer getAnswerById(Long id) {
            String sql = "SELECT * FROM " + ANSWER_TABLE_NAME + " WHERE id = ?";
            try {
                return jdbcTemplate.queryForObject(sql, new AnswerMapper(), id);
            } catch (EmptyResultDataAccessException error){
                return null;
            }
    }

    @Override
    public void updateAnswerById(Long id, Answer answer) {
        String sql = "UPDATE " + ANSWER_TABLE_NAME + " SET question_id=?, answer=? " + "WHERE id=?";
        jdbcTemplate.update(sql, answer.getQuestionId(),answer.getAnswerContent(), id);
    }

    @Override
    public void deleteAnswerById(Long id) {
        String sql = "DELETE FROM " + ANSWER_TABLE_NAME + " WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
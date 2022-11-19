package com.pollService.repository;

import com.pollService.model.Answer;
import com.pollService.repository.mapper.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository {

    private static final String ANSWER_TABLE_NAME = "answer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createAnswer(Answer answer) {
        String sql = "INSERT INTO " + ANSWER_TABLE_NAME + " (q_id, answer) VALUES (?, ?)";
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
        String sql = "UPDATE " + ANSWER_TABLE_NAME + " SET q_id=?, answer=? " + "WHERE id=?";
        jdbcTemplate.update(sql, answer.getQuestionId(),answer.getAnswerContent(), id);
    }

    @Override
    public void deleteAnswerById(Long id) {
        String sql = "DELETE FROM " + ANSWER_TABLE_NAME + " WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Answer> getAnswerByQuestionId(Long questionId) {
        String sql = "SELECT * FROM " + ANSWER_TABLE_NAME + " WHERE q_id = ?";
        try {
            return jdbcTemplate.query(sql, new AnswerMapper(), questionId);
        } catch (EmptyResultDataAccessException error){
            return null;
        }
    }

    @Override
    public void deleteAnswersByQuestionId(Long questionId) {
        String sql = "DELETE FROM " + ANSWER_TABLE_NAME + " WHERE q_id = ?";
        jdbcTemplate.update(sql, questionId);
    }


}

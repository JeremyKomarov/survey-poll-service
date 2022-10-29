package com.pollService.repository;

import com.pollService.repository.mapper.QuestionMapper;
import com.pollService.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private static final String QUESTIONS_TABLE_NAME = "question";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createQuestion(Question question) {
        String sql = "INSERT INTO " + QUESTIONS_TABLE_NAME + " (question) VALUES (?)";
        jdbcTemplate.update(sql, question.getQuestionContent());
    }

    @Override
    public Question getQuestionById(Long id) {
        String sql = "SELECT * FROM " + QUESTIONS_TABLE_NAME + " WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new QuestionMapper(), id);
        } catch (EmptyResultDataAccessException error){
        return null;
    }
    }

    @Override
    public void updateQuestionById(Long id, Question question) {
        String sql = "UPDATE " + QUESTIONS_TABLE_NAME + " SET question=? " + "WHERE id=?";
        jdbcTemplate.update(sql, question.getQuestionContent(), id);
    }

    @Override
    public void deleteQuestionById(Long id) {
        String sql = "DELETE FROM " + QUESTIONS_TABLE_NAME + " WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}

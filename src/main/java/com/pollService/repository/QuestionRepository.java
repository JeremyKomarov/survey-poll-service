package com.pollService.repository;

import com.pollService.model.Question;

public interface QuestionRepository {
    void createQuestion(Question question);
    Question getQuestionById(Long id);
    void updateQuestionById(Long id, Question question);
    void deleteQuestionById(Long id);

}

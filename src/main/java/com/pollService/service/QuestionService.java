package com.pollService.service;

import com.pollService.model.Question;
import com.pollService.model.QuestionRequest;

public interface QuestionService {
    void createQuestion(Question question);
    Question getQuestionById(Long id);
    void updateQuestionById(Long id, Question question);
    void deleteQuestionById(Long id);
    void createFullQuestionAnswers(QuestionRequest questionRequest);

}

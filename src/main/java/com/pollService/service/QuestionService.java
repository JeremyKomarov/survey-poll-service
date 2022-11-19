package com.pollService.service;

import com.pollService.model.Question;
import com.pollService.model.request.QuestionRequest;

public interface QuestionService {
    void createQuestion(Question question);
    Question getQuestionById(Long id) throws Exception;
    void updateQuestionById(Long id, Question question) throws Exception;
    void deleteQuestionById(Long id);
    void createFullQuestionAnswers(QuestionRequest questionRequest) throws Exception;

}

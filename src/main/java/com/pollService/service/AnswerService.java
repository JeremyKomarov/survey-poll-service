package com.pollService.service;

import com.pollService.model.Answer;

import java.util.List;

public interface AnswerService {
    void createAnswer(Answer answer) throws Exception;
    Answer getAnswerById(Long id) throws Exception;
    void updateAnswerById(Long id, Answer answer) throws Exception;
    void deleteAnswerById(Long id) throws Exception;
    List<Answer> getAnswerByQuestionId(Long questionId);
    void deleteAnswersByQuestionId(Long questionId);


}

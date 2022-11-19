package com.pollService.repository;

import com.pollService.model.Answer;

import java.util.List;

public interface AnswerRepository {
    void createAnswer(Answer answer);
    Answer getAnswerById(Long id);
    void updateAnswerById(Long id, Answer answer);
    void deleteAnswerById(Long id);
    List<Answer> getAnswerByQuestionId(Long questionId);
    void deleteAnswersByQuestionId(Long questionId);
}

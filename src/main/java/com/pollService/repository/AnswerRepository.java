package com.pollService.repository;

import com.pollService.model.Answer;

public interface AnswerRepository {
    void createAnswer(Answer answer);
    Answer getAnswerById(Long id);
    void updateAnswerById(Long id, Answer answer);
    void deleteAnswerById(Long id);
}

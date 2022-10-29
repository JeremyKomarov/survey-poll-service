package com.pollService.service;

import com.pollService.model.Answer;

public interface AnswerService {
    void createAnswer(Answer answer);
    Answer getAnswerById(Long id);
    void updateAnswerById(Long id, Answer answer);
    void deleteAnswerById(Long id);

}

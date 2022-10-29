package com.pollService.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollService.model.Answer;
import com.pollService.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createAnswer(Answer answer) {
        answerRepository.createAnswer(answer);
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.getAnswerById(id);
    }

    @Override
    public void updateAnswerById(Long id, Answer answer) {
        answerRepository.updateAnswerById(id, answer);
    }

    @Override
    public void deleteAnswerById(Long id) {
        answerRepository.deleteAnswerById(id);
    }
}




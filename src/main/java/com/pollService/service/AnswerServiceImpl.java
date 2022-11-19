package com.pollService.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollService.model.Answer;
import com.pollService.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    QuestionService questionService;
    @Autowired
    VoteService voteService;
    @Autowired
    AnswerService answerService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createAnswer(Answer answer) throws Exception {
        Long curQuestionId = answer.getQuestionId();
        if (questionService.getQuestionById(curQuestionId) != null)
        {
            answerRepository.createAnswer(answer);
        }else {
            throw new Exception("No question to add the answer");
        }


    }

    @Override
    public Answer getAnswerById(Long id) throws Exception {
        if (answerRepository.getAnswerById(id) != null)
        {
            return answerRepository.getAnswerById(id);
        } else {
            throw new Exception("No such answer");
        }

    }

    @Override
    public void updateAnswerById(Long id, Answer answer) throws Exception {
       if (answerRepository.getAnswerById(id) != null){
            if (questionService.getQuestionById(answer.getQuestionId()) != null)
            {
                answerRepository.updateAnswerById(id, answer);
            } else {
                throw new Exception("No such question to update the answer");
            }
       }else {
           throw new Exception("No such answer to update");
       }
    }

    @Override
    public void deleteAnswerById(Long id) throws Exception {
            answerRepository.deleteAnswerById(id);
    }

    @Override
    public List<Answer> getAnswerByQuestionId(Long questionId) {
        return  answerRepository.getAnswerByQuestionId(questionId);
    }

    @Override
    public void deleteAnswersByQuestionId(Long questionId) {
        answerRepository.deleteAnswersByQuestionId(questionId);
    }

    ;




}





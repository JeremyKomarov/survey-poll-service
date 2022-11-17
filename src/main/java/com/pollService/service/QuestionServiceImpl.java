package com.pollService.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollService.model.Question;
import com.pollService.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createQuestion(Question question) {
        questionRepository.createQuestion(question);
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.getQuestionById(id);
    }

    @Override
    public void updateQuestionById(Long id, Question question) {
        questionRepository.updateQuestionById(id, question);
    }

    @Override
    public void deleteQuestionById(Long id) {
        questionRepository.deleteQuestionById(id);
    }

    @Override
    public QuestionFullAnswersResponse getFullQuestionAndAnswersByQuestionId(Long questionId) {
        return questionRepository.getFullQuestionAndAnswersByQuestionId(questionId);
    }


}

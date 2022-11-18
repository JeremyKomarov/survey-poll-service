package com.pollService.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollService.model.Answer;
import com.pollService.model.Question;
import com.pollService.model.QuestionRequest;
import com.pollService.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerService answerService;
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
    public void createFullQuestionAnswers(QuestionRequest questionRequest) {
        Question curQuestion = questionRequest.getQuestion();
        Long curQuestionId = questionRepository.createQuestion(curQuestion);
        List<Answer> curAnswers = questionRequest.getAnswer();
        for (int i = 0; i < curAnswers.size(); i++){
            String curAnswerContent = curAnswers.get(i).getAnswerContent();
            answerService.createAnswer(questionRequest.toAnswer(curQuestionId,curAnswerContent));
        }
    }
}

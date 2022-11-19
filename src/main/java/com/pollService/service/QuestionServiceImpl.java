package com.pollService.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollService.model.Answer;
import com.pollService.model.Question;
import com.pollService.model.request.QuestionRequest;
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
    public Question getQuestionById(Long id) throws Exception {
        if (questionRepository.getQuestionById(id) != null)
        {
            return questionRepository.getQuestionById(id);
        }else {
            throw new Exception("No such question");
        }

    }

    @Override
    public void updateQuestionById(Long id, Question question) throws Exception {
        if (questionRepository.getQuestionById(id) != null)
        {
            questionRepository.updateQuestionById(id, question);
        }
        else {
            throw new Exception("No such question to update");
        }

    }

    @Override
    public void deleteQuestionById(Long id) throws Exception {
        if (answerService.getAnswerByQuestionId(id) == null){
            questionRepository.deleteQuestionById(id);
        }else {
            throw new Exception("cant delete question because it has answers");
        }

    }

    @Override
    public void createFullQuestionAnswers(QuestionRequest questionRequest) throws Exception {
        Question curQuestion = questionRequest.getQuestion();
        Long curQuestionId = questionRepository.createQuestion(curQuestion);
        List<Answer> curAnswers = questionRequest.getAnswer();
        for (int i = 0; i < curAnswers.size(); i++){
            String curAnswerContent = curAnswers.get(i).getAnswerContent();
            answerService.createAnswer(questionRequest.toAnswer(curQuestionId,curAnswerContent));
        }
    }

    @Override
    public void deleteFullQuestionAnswers(Long id) {
        answerService.deleteAnswersByQuestionId(id);
        questionRepository.deleteQuestionById(id);
    }
}

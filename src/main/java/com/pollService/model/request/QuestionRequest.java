package com.pollService.model.request;

import com.pollService.model.Answer;
import com.pollService.model.Question;

import java.util.List;

public class QuestionRequest {
    Question question;
    List<Answer> answer;

    public QuestionRequest(Question question, List<Answer> answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public Answer toAnswer(Long questionId, String answerContent){
      return new Answer(
                null,
                questionId,
                answerContent
        );
    };
}

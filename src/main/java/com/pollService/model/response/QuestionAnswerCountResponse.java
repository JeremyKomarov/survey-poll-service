package com.pollService.model.response;

public class QuestionAnswerCountResponse {
    String question;
    String answer;
    Long count;

    public QuestionAnswerCountResponse(String question, String answer, Long count) {
        this.question = question;
        this.answer = answer;
        this.count = count;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Long getCount() {
        return count;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

package com.pollService.model.response;

public class QuestionCountResponse {
    String question;
    Long count;

    public QuestionCountResponse(String question, Long count) {
        this.question = question;
        this.count = count;
    }

    public String getQuestion() {
        return question;
    }

    public Long getCount() {
        return count;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

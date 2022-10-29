package com.pollService.model;

public class Question {
    private Long id;
    private String questionContent;

    public Question(Long id, String questionContent) {
        this.id = id;
        this.questionContent = questionContent;
    }

    public Long getId() {
        return id;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}


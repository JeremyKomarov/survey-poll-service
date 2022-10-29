package com.pollService.model;

public class Answer {
    private Long id;
    private Long questionId;
    private String answerContent;

    public Answer(Long id, Long questionId, String answerContent) {
        this.id = id;
        this.questionId = questionId;
        this.answerContent = answerContent;
    }

    public Long getId() {
        return id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
}

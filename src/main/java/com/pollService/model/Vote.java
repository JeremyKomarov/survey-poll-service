package com.pollService.model;

public class Vote {
    private Long id;
    private Long questionId;
    private Long answerId;

    public Vote(Long id, Long questionId, Long answerId) {
        this.id = id;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public Long getId() {
        return id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
}

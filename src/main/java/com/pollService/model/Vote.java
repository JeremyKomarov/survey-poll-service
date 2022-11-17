package com.pollService.model;

public class Vote {
    private Long id;
    private Long userId;
    private Long questionId;
    private Long answerId;

    public Vote(Long id, Long userId, Long questionId, Long answerId) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }
}

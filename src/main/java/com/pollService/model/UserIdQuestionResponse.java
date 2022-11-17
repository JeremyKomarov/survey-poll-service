package com.pollService.model;

public class UserIdQuestionResponse {
    Long user_id;
    Long questionAnswered;

    public UserIdQuestionResponse(Long user_id, Long questionAnswered) {
        this.user_id = user_id;
        this.questionAnswered = questionAnswered;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Long getQuestionAnswered() {
        return questionAnswered;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setQuestionAnswered(Long questionAnswered) {
        this.questionAnswered = questionAnswered;
    }
}

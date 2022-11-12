package com.pollService.model;

public class CreateQuestionResponse {
    private Question question;
    private Answer answerA;
    private Answer answerB;
    private Answer answerC;
    private Answer answerD;

    public CreateQuestionResponse(Question question, Answer answerA, Answer answerB, Answer answerC, Answer answerD) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
    }

    public Question getQuestion() {
        return question;
    }

    public Answer getAnswerA() {
        return answerA;
    }

    public Answer getAnswerB() {
        return answerB;
    }

    public Answer getAnswerC() {
        return answerC;
    }

    public Answer getAnswerD() {
        return answerD;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setAnswerA(Answer answerA) {
        this.answerA = answerA;
    }

    public void setAnswerB(Answer answerB) {
        this.answerB = answerB;
    }

    public void setAnswerC(Answer answerC) {
        this.answerC = answerC;
    }

    public void setAnswerD(Answer answerD) {
        this.answerD = answerD;
    }
}

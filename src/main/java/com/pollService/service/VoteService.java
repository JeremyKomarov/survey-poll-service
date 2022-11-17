package com.pollService.service;

import com.pollService.model.*;

import java.util.List;

public interface VoteService {
    void createVote(Vote vote) throws Exception;
    Vote getVoteById(Long id);
    void updateVoteById(Long id, Vote vote);
    void deleteVoteById(Long id);
    void deleteAllVotesByUserId(Long userId);
    List<QuestionAnswerCountResponse> getTotalAnsweredQuestionCountByQuestionId(Long questionId);
    QuestionCountResponse getTotalChosenQuestionByQuestionId(Long questionId);
    List<QuestionAnswerResponse> getUserQuestionOptionsByUserId(Long userId);
    UserIdQuestionResponse getTotalUserQuestionsCount(Long userId);
    List<QuestionAnswerCountResponse> getAllQuestionAnswers();
}

package com.pollService.repository;

import com.pollService.model.*;
import com.pollService.model.response.QuestionAnswerCountResponse;
import com.pollService.model.response.QuestionAnswerResponse;
import com.pollService.model.response.QuestionCountResponse;
import com.pollService.model.response.UserIdQuestionResponse;

import java.util.List;

public interface VoteRepository {
    void createVote(Vote vote);
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

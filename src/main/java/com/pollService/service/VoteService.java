package com.pollService.service;

import com.pollService.model.*;
import com.pollService.model.response.QuestionAnswerCountResponse;
import com.pollService.model.response.QuestionAnswerResponse;
import com.pollService.model.response.QuestionCountResponse;
import com.pollService.model.response.UserIdQuestionResponse;

import java.util.List;

public interface VoteService {
    void createVote(Vote vote) throws Exception;
    Vote getVoteById(Long id) throws Exception;
    void updateVoteById(Long id, Vote vote) throws Exception;
    void deleteVoteById(Long id) throws Exception;
    void deleteAllVotesByUserId(Long userId);
    List<QuestionAnswerCountResponse> getTotalAnsweredQuestionCountByQuestionId(Long questionId);
    QuestionCountResponse getTotalChosenQuestionByQuestionId(Long questionId);
    List<QuestionAnswerResponse> getUserQuestionOptionsByUserId(Long userId);
    UserIdQuestionResponse getTotalUserQuestionsCount(Long userId);
    List<QuestionAnswerCountResponse> getAllQuestionAnswers();


}

package com.pollService.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollService.model.*;
import com.pollService.repository.VoteRepository;
import com.pollService.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService{

    @Autowired
    VoteRepository voteRepository;
    @Autowired
    UserService userService;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createVote(Vote vote) throws Exception {
        Long curVote = vote.getUserId();
        User curUser = userService.getUserById(curVote);

        if (curUser != null ){
            voteRepository.createVote(vote);
        }else {
            throw new Exception("The user is not registered, Please register to vote");
        }
    };

    @Override
    public Vote getVoteById(Long id){
        return voteRepository.getVoteById(id);
    }

    @Override
    public void updateVoteById(Long id, Vote vote) {
        voteRepository.updateVoteById(id, vote);
    }

    @Override
    public void deleteVoteById(Long id) {
        voteRepository.deleteVoteById(id);
    }

    @Override
    public void deleteAllVotesByUserId(Long userId) {
        voteRepository.deleteAllVotesByUserId(userId);
    }


    @Override
    public List<QuestionAnswerCountResponse> getTotalAnsweredQuestionCountByQuestionId(Long questionId) {
        return voteRepository.getTotalAnsweredQuestionCountByQuestionId(questionId);
    }

    @Override
    public QuestionCountResponse getTotalChosenQuestionByQuestionId(Long questionId) {
        return voteRepository.getTotalChosenQuestionByQuestionId(questionId);
    }

    @Override
    public List<QuestionAnswerResponse> getUserQuestionOptionsByUserId(Long userId) {
        return voteRepository.getUserQuestionOptionsByUserId(userId);
    }

    @Override
    public UserIdQuestionResponse getTotalUserQuestionsCount(Long userId) {
        return voteRepository.getTotalUserQuestionsCount(userId);
    }

    @Override
    public List<QuestionAnswerCountResponse> getAllQuestionAnswers() {
        return voteRepository.getAllQuestionAnswers();
    }


}

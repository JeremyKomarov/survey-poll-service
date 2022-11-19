package com.pollService.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollService.model.*;
import com.pollService.model.response.QuestionAnswerCountResponse;
import com.pollService.model.response.QuestionAnswerResponse;
import com.pollService.model.response.QuestionCountResponse;
import com.pollService.model.response.UserIdQuestionResponse;
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
    public Vote getVoteById(Long id) throws Exception {
        if (voteRepository.getVoteById(id) != null)
        {
            return voteRepository.getVoteById(id);
        }else {
            throw new Exception("No such vote");
        }
    }

    @Override
    public void updateVoteById(Long id, Vote vote) throws Exception {
        if (voteRepository.getVoteById(id) != null)
        {
            voteRepository.updateVoteById(id, vote);
        }else {
            throw new Exception("No such vote to update");
        }
    }

    @Override
    public void deleteVoteById(Long id) throws Exception {
        if (voteRepository.getVoteById(id) != null){
            voteRepository.deleteVoteById(id);
        }else {
            throw new Exception("No such Vote to delete");
        }
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

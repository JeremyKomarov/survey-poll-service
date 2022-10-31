package com.pollService.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pollService.model.Vote;
import com.pollService.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService{

    @Autowired
    VoteRepository voteRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createVote(Vote vote) {
        voteRepository.createVote(vote);
    };

    @Override
    public Vote getVoteById(Long id) {
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
    public List<Long> getQuestionCountByQuestionId(Long questionId){
        return voteRepository.getQuestionCountByQuestionId(questionId);
    }
}

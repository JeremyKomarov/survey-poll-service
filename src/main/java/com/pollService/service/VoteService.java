package com.pollService.service;

import com.pollService.model.Vote;

public interface VoteService {
    void createVote(Vote vote);
    Vote getVoteById(Long id);
    void updateVoteById(Long id, Vote vote);
    void deleteVoteById(Long id);
}

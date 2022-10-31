package com.pollService.controller;
import com.pollService.model.Vote;
import com.pollService.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping(value = "/vote/create")
    public void createVote(@RequestBody Vote vote){
        voteService.createVote(vote);
    }

    @GetMapping(value = "/vote/{id}")
    public Vote getVoteById(@PathVariable Long id){
        return voteService.getVoteById(id);
    }

    @PutMapping(value = "/vote/{id}/update")
    public void updateVoteById(@PathVariable Long id,
                                   @RequestBody Vote vote){
        voteService.updateVoteById(id, vote);
    }

    @DeleteMapping(value = "/vote/{id}/delete")
    public void deleteVoteById(@PathVariable Long id){
        voteService.deleteVoteById(id);
    }

    @GetMapping(value = "/vote/{questionId}/count")
    public List<Long> getQuestionCountByQuestionId(@PathVariable Long questionId){
        return voteService.getQuestionCountByQuestionId(questionId);
    }


}

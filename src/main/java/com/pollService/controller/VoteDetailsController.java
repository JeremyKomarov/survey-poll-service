package com.pollService.controller;

import com.pollService.model.response.QuestionAnswerCountResponse;
import com.pollService.model.response.QuestionAnswerResponse;
import com.pollService.model.response.QuestionCountResponse;
import com.pollService.model.response.UserIdQuestionResponse;
import com.pollService.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoteDetailsController {
    @Autowired
    VoteService voteService;

    @GetMapping(value = "/count/totalAnsweredQuestionOptionsCount/{questionId}")
    List<QuestionAnswerCountResponse> getTotalAnsweredQuestionCountByQuestionId(@PathVariable Long questionId){
        return voteService.getTotalAnsweredQuestionCountByQuestionId(questionId);
    }

    @GetMapping(value = "/count/totalUsersAnsweredToQuestion/{questionId}")
    QuestionCountResponse getTotalChosenQuestionByQuestionId(@PathVariable Long questionId){
        return voteService.getTotalChosenQuestionByQuestionId(questionId);
    }

    @GetMapping(value = "/count/userQuestionOptions/{userId}")
    List<QuestionAnswerResponse> getUserQuestionOptionsByUserId(@PathVariable Long userId){
        return voteService.getUserQuestionOptionsByUserId(userId);
    }

    @GetMapping(value = "/count/userTotalQuestionsCount/{userId}")
    UserIdQuestionResponse getTotalUserQuestionsCount(@PathVariable Long userId){
        return voteService.getTotalUserQuestionsCount(userId);
    }

    @GetMapping(value = "/count/allQuestionsAnswersCount")
    List<QuestionAnswerCountResponse> getAllQuestionAnswers(){
        return voteService.getAllQuestionAnswers();
    }
}

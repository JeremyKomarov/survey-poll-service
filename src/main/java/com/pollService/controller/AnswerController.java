package com.pollService.controller;
import com.pollService.model.Answer;
import com.pollService.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping(value = "/answer/create")
    public void createAnswer(@RequestBody Answer answer) throws Exception {
        answerService.createAnswer(answer);
    }

    @GetMapping(value = "/answer/{id}")
    public Answer getAnswerById(@PathVariable Long id) throws Exception {
        return answerService.getAnswerById(id);
    }

    @PutMapping(value = "/answer/{id}/update")
    public void updateAnswerById(@PathVariable Long id,
                                 @RequestBody Answer answer) throws Exception {
        answerService.updateAnswerById(id, answer);
    }

    @DeleteMapping(value = "/answer/{id}/delete")
    public void deleteAnswerById(@PathVariable Long id) throws Exception {
        answerService.deleteAnswerById(id);
    }

    @GetMapping(value = "/answer/{questionId}/byQuestionId")
    public List<Answer> getAnswerByQuestionId (@PathVariable Long questionId) throws Exception {
        return answerService.getAnswerByQuestionId(questionId);
    };

    @DeleteMapping(value = "/answer/{questionId}/byQuestionId")
    public void deleteAnswersByQuestionId(@PathVariable Long questionId){
        answerService.deleteAnswersByQuestionId(questionId);
    }

}

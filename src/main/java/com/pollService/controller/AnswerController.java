package com.pollService.controller;
import com.pollService.model.Answer;
import com.pollService.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping(value = "/answer/create")
    public void createAnswer(@RequestBody Answer answer){
        answerService.createAnswer(answer);
    }

    @GetMapping(value = "/answer/{id}")
    public Answer getAnswerById(@PathVariable Long id){
        return answerService.getAnswerById(id);
    }

    @PutMapping(value = "/answer/{id}/update")
    public void updateAnswerById(@PathVariable Long id,
                                 @RequestBody Answer answer){
        answerService.updateAnswerById(id, answer);
    }

    @DeleteMapping(value = "/answer/{id}/delete")
    public void deleteAnswerById(@PathVariable Long id){
        answerService.deleteAnswerById(id);
    }


}

package com.pollService.controller;
import com.pollService.model.Question;
import com.pollService.model.request.QuestionRequest;
import com.pollService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping(value = "/question/create")
    public void createQuestion(@RequestBody Question question){
        questionService.createQuestion(question);
    }

    @GetMapping(value = "/question/{id}")
    public Question getQuestionById(@PathVariable Long id) throws Exception {
        return questionService.getQuestionById(id);
    }

    @PutMapping(value = "/question/{id}/update")
    public void updateQuestionById(@PathVariable Long id,
                                   @RequestBody Question question) throws Exception {
        questionService.updateQuestionById(id, question);
    }

    @DeleteMapping(value = "/question/{id}/delete")
    public void deleteQuestionById(@PathVariable Long id) throws Exception {
        questionService.deleteQuestionById(id);
    }

    @PostMapping(value = "/question/createFullQuestionAnswers")
    public void createFullQuestionAnswers(@RequestBody QuestionRequest questionRequest) throws Exception {
        questionService.createFullQuestionAnswers(questionRequest);

    };

    @DeleteMapping(value = "/question/{id}/deleteFullQuestionAnswers")
    public void deleteFullQuestionAnswers(@PathVariable Long id){
        questionService.deleteFullQuestionAnswers(id);
    };
}


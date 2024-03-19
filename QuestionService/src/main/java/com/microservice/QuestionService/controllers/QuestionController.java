package com.microservice.QuestionService.controllers;

import com.microservice.QuestionService.models.Question;
import com.microservice.QuestionService.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final IQuestionService questionService;

    @PostMapping
    Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    @GetMapping
    List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{questionId}")
    Question getById(@PathVariable Long questionId) {
        return questionService.getById(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    List<Question> getAllByQuizId(@PathVariable Long quizId) {
        return questionService.getAllByQuizId(quizId);
    }
}

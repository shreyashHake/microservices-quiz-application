package com.microservice.QuizService.controllers;

import com.microservice.QuizService.models.Quiz;
import com.microservice.QuizService.services.IQuizService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final IQuizService quizService;

   @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
       return quizService.create(quiz);
   }

   @GetMapping
    public List<Quiz> getAll() {
       return quizService.getAll();
   }

   @GetMapping("/{quizId}")
    public Quiz getById(@PathVariable Long quizId) {
       return quizService.getById(quizId);
   }
}

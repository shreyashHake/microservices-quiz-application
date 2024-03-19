package com.microservice.QuizService.services;

import com.microservice.QuizService.models.Quiz;

import java.util.List;

public interface IQuizService {
    Quiz create(Quiz quiz);
    List<Quiz> getAll();
    Quiz getById(Long quizId);
}

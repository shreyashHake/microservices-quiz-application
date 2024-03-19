package com.microservice.QuestionService.services;

import com.microservice.QuestionService.models.Question;

import java.util.List;

public interface IQuestionService {
    Question create(Question question);
    List<Question> getAll();
    Question getById(Long questionId);
    List<Question> getAllByQuizId(Long quizId);
}

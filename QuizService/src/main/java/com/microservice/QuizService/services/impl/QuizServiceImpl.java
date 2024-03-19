package com.microservice.QuizService.services.impl;

import com.microservice.QuizService.models.Quiz;
import com.microservice.QuizService.repositories.IQuizRepository;
import com.microservice.QuizService.services.IQuestionClient;
import com.microservice.QuizService.services.IQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements IQuizService {
    private final IQuizRepository quizRepository;
    private final IQuestionClient questionClient;

    @Override
    public Quiz create(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream().peek(
                quiz -> quiz.setQuestions(questionClient.getAllQuestionByQuizId(quiz.getQuizId()))
        ).collect(Collectors.toList());
    }

    @Override
    public Quiz getById(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getAllQuestionByQuizId(quizId));
        return quiz;
    }
}

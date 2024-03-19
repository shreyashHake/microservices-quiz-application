package com.microservice.QuestionService.services.impl;

import com.microservice.QuestionService.models.Question;
import com.microservice.QuestionService.repositories.IQuestionRepository;
import com.microservice.QuestionService.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements IQuestionService {
    private final IQuestionRepository questionRepository;

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getAllByQuizId(Long quizId) {
        return questionRepository.findAByQuizId(quizId);
    }
}

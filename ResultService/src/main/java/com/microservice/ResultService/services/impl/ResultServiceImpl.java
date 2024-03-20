package com.microservice.ResultService.services.impl;

import com.microservice.ResultService.models.Result;
import com.microservice.ResultService.repositories.ResultRepository;
import com.microservice.ResultService.services.QuizClient;
import com.microservice.ResultService.services.ResultServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultServices {
    private final ResultRepository resultRepository;
    private final QuizClient quizClient;

    @Override
    public Result createResult(Result request) {
        return resultRepository.save(request);
    }

    @Override
    public Result getResultById(Long id) {
        Result result = resultRepository.findById(id).orElseThrow(() -> new RuntimeException("Result not found"));
        result.setQuiz(quizClient.findQuizByResultId(id));
        return result;
    }

    @Override
    public List<Result> getAllResult() {
        List<Result> results = resultRepository.findAll();
        return results.stream().peek(
                result -> result.setQuiz(quizClient.findQuizByResultId(result.getId()))
        ).collect(Collectors.toList());
    }
}

package com.microservice.ResultService.services;

import com.microservice.ResultService.models.Quiz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "QUIZ-SERVICE")
public interface QuizClient {
    @GetMapping("/quiz/result/{id}")
    Quiz findQuizByResultId(@PathVariable("id") Long resultId);
}

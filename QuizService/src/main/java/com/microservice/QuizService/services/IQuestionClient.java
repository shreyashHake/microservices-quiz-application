package com.microservice.QuizService.services;

import com.microservice.QuizService.models.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// using url
// @FeignClient(url = "http://localhost:8081", value = "Question-Client")

// using Application name in Eureka server - QUESTION-SERVICE
@FeignClient(name = "QUESTION-SERVICE")
// this 'name' is same as spring.application.name in the application.properties of Question-Service
public interface IQuestionClient {
    @GetMapping("/question/quiz/{quizId}")
    List<Question> getAllQuestionByQuizId(@PathVariable Long quizId);
}

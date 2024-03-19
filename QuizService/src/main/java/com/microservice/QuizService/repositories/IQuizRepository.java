package com.microservice.QuizService.repositories;

import com.microservice.QuizService.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuizRepository extends JpaRepository<Quiz, Long> {
}

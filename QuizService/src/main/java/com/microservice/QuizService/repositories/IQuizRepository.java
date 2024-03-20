package com.microservice.QuizService.repositories;

import com.microservice.QuizService.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IQuizRepository extends JpaRepository<Quiz, Long> {
    Quiz findByResultId(Long resultId);
}

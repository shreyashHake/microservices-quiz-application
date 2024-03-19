package com.microservice.QuestionService.repositories;

import com.microservice.QuestionService.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IQuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAByQuizId(Long quizId);
}

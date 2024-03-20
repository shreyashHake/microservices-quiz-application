package com.microservice.ResultService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    private Long quizId;
    private String title;
//    private List<Question> questions;
}

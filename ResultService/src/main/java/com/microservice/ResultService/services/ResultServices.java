package com.microservice.ResultService.services;

import com.microservice.ResultService.models.Result;

import java.util.List;

public interface ResultServices {
    Result createResult(Result request);
    Result getResultById(Long id);
    List<Result> getAllResult();
}

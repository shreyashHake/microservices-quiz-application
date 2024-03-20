package com.microservice.ResultService.repositories;

import com.microservice.ResultService.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}

package com.microservice.ResultService.controllers;

import com.microservice.ResultService.models.Result;
import com.microservice.ResultService.services.ResultServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
@RequiredArgsConstructor
public class ResultController {
    private final ResultServices resultService;

    @PostMapping()
    public Result create(@RequestBody Result result) {
        return resultService.createResult(result);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Long id) {
        return resultService.getResultById(id);
    }

    @GetMapping
    public List<Result> getAll() {
        return resultService.getAllResult();
    }
}

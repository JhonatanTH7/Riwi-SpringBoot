package com.riwi.operations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class HelloWorldController {

    @GetMapping
    public String greet() {
        return "Hello World";
    }
}
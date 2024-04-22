package com.riwi.operations.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.operations.entities.Operations;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationsController {

    @PostMapping(path = "/sum")
    public String sum(@RequestBody Operations objOperations) {
        String result = String.valueOf(objOperations.getNum1() + objOperations.getNum2());
        return " -->  " + objOperations.getNum1() + " + " + objOperations.getNum2() + " = " + result;
    }

    @PostMapping(path = "/subtract")
    public String subtract(@RequestBody Operations objOperations) {
        String result = String.valueOf(objOperations.getNum1() - objOperations.getNum2());
        return " -->  " + objOperations.getNum1() + " - " + objOperations.getNum2() + " = " + result;
    }

    @PostMapping(path = "/multiplication")
    public String multiplication(@RequestBody Operations objOperations) {
        String result = String.valueOf(objOperations.getNum1() * objOperations.getNum2());
        return " -->  " + objOperations.getNum1() + " x " + objOperations.getNum2() + " = " + result;
    }

    @PostMapping(path = "/division")
    public String division(@RequestBody Operations objOperations) {
        String result = " -->  ";
        if (objOperations.getNum2() != 0) {
            result = String.valueOf(objOperations.getNum1() / objOperations.getNum2());
            return " -->  " + objOperations.getNum1() + " / " + objOperations.getNum2() + " = " + result;
        } else {
            result = "division by zero not allowed";
        }
        return result;
    }
}
package com.riwi.RelationsInSpringboot.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RelationsInSpringboot.services.interfaces.IVacantService;
import com.riwi.RelationsInSpringboot.utils.dto.request.VacantRequest;
import com.riwi.RelationsInSpringboot.utils.dto.response.VacantResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/vacant")
@AllArgsConstructor
public class VacantController {

    @Autowired
    private final IVacantService objIVacantService;

    @GetMapping
    public ResponseEntity<Page<VacantResponse>> getAll(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(this.objIVacantService.getAll(page - 1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VacantResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(this.objIVacantService.getById(id));
    }

    @PostMapping
    public ResponseEntity<VacantResponse> add(@Validated @RequestBody VacantRequest objVacantRequest) {
        return ResponseEntity.ok(this.objIVacantService.create(objVacantRequest));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable String id) {

        Map<String, String> response = new HashMap<>();
        response.put("message", "Vacante eliminada correctamente");
        this.objIVacantService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<VacantResponse> update(
            @PathVariable String id,
            @Validated @RequestBody VacantRequest objVacantRequest) {
        return ResponseEntity.ok(this.objIVacantService.update(objVacantRequest, id));
    }
};
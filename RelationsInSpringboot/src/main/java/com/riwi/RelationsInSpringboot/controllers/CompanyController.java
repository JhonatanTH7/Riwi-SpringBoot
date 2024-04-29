package com.riwi.RelationsInSpringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.RelationsInSpringboot.services.interfaces.ICompanyService;
import com.riwi.RelationsInSpringboot.utils.dto.request.CompanyRequest;
import com.riwi.RelationsInSpringboot.utils.dto.response.CompanyResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/company")
@AllArgsConstructor
public class CompanyController {

    @Autowired
    private final ICompanyService objICompanyService;

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> get(@PathVariable String id) {
        return ResponseEntity.ok(this.objICompanyService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<CompanyResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok(this.objICompanyService.getAll(page - 1, size));
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> insert(@RequestBody CompanyRequest objCompanyRequest) {
        return ResponseEntity.ok(this.objICompanyService.create(objCompanyRequest));
    }
}

package com.riwi.BeautySalon.api.controllers;

import java.util.Objects;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.BeautySalon.api.dto.request.ServiceEntityReq;
import com.riwi.BeautySalon.api.dto.response.ServiceEntityResp;
import com.riwi.BeautySalon.infrastructure.abstract_services.IServiceEntityService;
import com.riwi.BeautySalon.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/services")
@AllArgsConstructor
public class ServiceEntityController {

    @Autowired
    private final IServiceEntityService objIServiceEntityService;

    @GetMapping
    public ResponseEntity<Page<ServiceEntityResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestHeader(required = false) SortType sortType) {

        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }
        return ResponseEntity.ok(this.objIServiceEntityService.getAll(page - 1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ServiceEntityResp> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(this.objIServiceEntityService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceEntityResp> add(
            @Validated @RequestBody ServiceEntityReq request) {
        return ResponseEntity.ok(this.objIServiceEntityService.create(request));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        this.objIServiceEntityService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ServiceEntityResp> update(
            @Validated @RequestBody ServiceEntityReq obServiceEntityReq,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.objIServiceEntityService.update(obServiceEntityReq, id));
    }
}

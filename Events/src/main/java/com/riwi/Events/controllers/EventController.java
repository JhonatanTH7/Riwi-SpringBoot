package com.riwi.Events.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Events.entities.Event;
import com.riwi.Events.services.serviceAbstract.IEventService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/events")
@AllArgsConstructor
public class EventController {

    @Autowired
    private final IEventService objIEventService;

    @GetMapping
    public ResponseEntity<Page<Event>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok(this.objIEventService.getAll(page - 1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> get(@PathVariable String id) {
        return ResponseEntity.ok(this.objIEventService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Event> add(@RequestBody Event objEvent) {
        validateData(objEvent);
        return ResponseEntity.ok(this.objIEventService.add(objEvent));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(@PathVariable String id, @RequestBody Event objEvent) {
        validateData(objEvent);
        return ResponseEntity.ok(this.objIEventService.update(id, objEvent));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.objIEventService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private boolean validateData(Event objEvent) {
        if (objEvent.getCapacity() < 1) {
            throw new IllegalArgumentException("Capacity can't be less than one");
        }
        if (objEvent.getDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date entered has already passed");
        }
        return true;
    }
}

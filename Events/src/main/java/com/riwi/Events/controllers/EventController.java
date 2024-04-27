package com.riwi.Events.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(this.objIEventService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> get(@PathVariable String id) {
        return ResponseEntity.ok(this.objIEventService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Event> add(@RequestBody Event objEvent) {
        return ResponseEntity.ok(this.objIEventService.add(objEvent));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Event> update(@PathVariable String id, @RequestBody Event objEvent) {
        return ResponseEntity.ok(this.objIEventService.update(id, objEvent));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.objIEventService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

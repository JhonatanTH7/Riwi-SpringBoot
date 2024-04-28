package com.riwi.Events.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.Events.entities.Event;
import com.riwi.Events.repositories.EventRepository;
import com.riwi.Events.services.serviceAbstract.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService {

    @Autowired
    private final EventRepository objEventRepository;

    @Override
    public Event add(Event objEvent) {

        return this.objEventRepository.save(objEvent);
    }

    @Override
    public Page<Event> getAll(int page, int size) {
        if (page < 0) {
            page = 1;
        }
        PageRequest pagination = PageRequest.of(page, size);
        return this.objEventRepository.findAll(pagination);
    }

    @Override
    public Event findById(String id) {
        return this.objEventRepository.findById(id).orElseThrow();
    }

    @Override
    public Event update(String id, Event objEvent) {
        this.objEventRepository.findById(id).orElseThrow();
        objEvent.setId(id);
        return this.objEventRepository.save(objEvent);
    }

    @Override
    public void delete(String id) {
        Event objEvent = this.objEventRepository.findById(id).orElseThrow();
        this.objEventRepository.delete(objEvent);
    }
}

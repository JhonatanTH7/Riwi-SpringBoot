package com.riwi.Events.services.serviceAbstract;

import org.springframework.data.domain.Page;

import com.riwi.Events.entities.Event;

public interface IEventService {
    public Event add(Event objEvent);

    public Page<Event> getAll(int page, int size);

    public Event findById(String id);

    public Event update(String id, Event objEvent);

    public void delete(String id);
}

package com.riwi.Events.services.serviceAbstract;

import java.util.List;

import com.riwi.Events.entities.Event;

public interface IEventService {
    public Event add(Event objEvent);

    public List<Event> getAll();

    public Event findById(String id);

    public Event update(String id, Event objEvent);

    public void delete(String id);
}

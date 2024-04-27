package com.riwi.Events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.Events.entities.Event;

public interface EventRepository extends JpaRepository<Event, String> {

}

package com.digi.trainers.hack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.trainers.hack.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}

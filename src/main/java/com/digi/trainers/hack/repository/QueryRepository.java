package com.digi.trainers.hack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.trainers.hack.model.Query;

public interface QueryRepository extends JpaRepository<Query, Integer> {

}

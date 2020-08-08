package com.digi.trainers.hack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.trainers.hack.model.Doubt;

public interface DoubtRepository extends JpaRepository<Doubt, Integer> {

}

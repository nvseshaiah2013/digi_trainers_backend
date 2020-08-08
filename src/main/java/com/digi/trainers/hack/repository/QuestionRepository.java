package com.digi.trainers.hack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.trainers.hack.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}

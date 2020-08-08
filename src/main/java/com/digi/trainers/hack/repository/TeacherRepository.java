package com.digi.trainers.hack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.trainers.hack.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}

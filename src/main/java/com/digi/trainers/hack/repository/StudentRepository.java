package com.digi.trainers.hack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.trainers.hack.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}

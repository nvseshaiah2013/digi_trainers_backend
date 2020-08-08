package com.digi.trainers.hack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.trainers.hack.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}

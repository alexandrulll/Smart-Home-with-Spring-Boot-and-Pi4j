package com.example.scutaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scutaru.domain.MotionSensor;

public interface MotionRepository extends JpaRepository<MotionSensor, Long>{

}

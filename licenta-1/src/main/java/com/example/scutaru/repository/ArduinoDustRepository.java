package com.example.scutaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scutaru.domain.DustSensor;

public interface ArduinoDustRepository extends JpaRepository<DustSensor, Long> {

}

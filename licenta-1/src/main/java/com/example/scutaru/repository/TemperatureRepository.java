package com.example.scutaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scutaru.domain.Temperature;

public interface TemperatureRepository extends JpaRepository<Temperature, Long> {

	Temperature findFirstByOrderByIdDesc();

}

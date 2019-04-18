package com.example.scutaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scutaru.domain.Humidity;

public interface HumidityRepository extends JpaRepository<Humidity, Long> {

	Humidity findFirstByOrderByIdDesc();
}

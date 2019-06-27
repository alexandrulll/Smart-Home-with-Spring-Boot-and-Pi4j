package com.example.scutaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scutaru.dto.TemperatureAlarmConfig;

@Repository
public interface TemperatureAlarmConfigRepository extends JpaRepository<TemperatureAlarmConfig, Long> {

}

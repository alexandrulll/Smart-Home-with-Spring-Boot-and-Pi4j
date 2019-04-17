package com.example.scutaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scutaru.domain.Alarm;

public interface AlarmRepository extends JpaRepository<Alarm, Long> {

}

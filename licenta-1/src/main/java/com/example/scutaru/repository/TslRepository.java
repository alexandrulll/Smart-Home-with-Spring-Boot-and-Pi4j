package com.example.scutaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scutaru.domain.TSL;

public interface TslRepository extends JpaRepository<TSL, Long> {

	TSL findFirstByOrderByIdDesc();
}

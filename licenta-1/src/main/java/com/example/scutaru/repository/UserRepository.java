package com.example.scutaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scutaru.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

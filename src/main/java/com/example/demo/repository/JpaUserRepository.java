package com.example.demo.repository;

import com.example.demo.dto.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {

}

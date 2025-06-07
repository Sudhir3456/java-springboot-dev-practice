package com.qspider.springsecuritywithdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspider.springsecuritywithdb.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
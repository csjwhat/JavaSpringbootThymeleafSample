package com.example.hajibootthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hajibootthymeleaf.domain.User;

public interface UserRepository extends JpaRepository<User, String>{

}

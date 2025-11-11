package com.example.FoodShare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodShare.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}

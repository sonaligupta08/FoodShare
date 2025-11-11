package com.example.FoodShare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.FoodShare.entity.User;
import com.example.FoodShare.repository.UserRepository;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	public String signup(@RequestBody User user) {
		if (userRepository.findByEmail(user.getEmail()) != null) {
			return "Email already registered";
		}
		userRepository.save(user);
		return "User registered successfully";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		User existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid email or password!";
        }
	}

}

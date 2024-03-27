package com.startingjpa.usejpa;

import org.springframework.context.ApplicationContext;

import com.startingjpa.usejpa.entities.User;
import com.startingjpa.usejpa.dao.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsejpaApplication {

	public static void main(String[] args) {

		// Create

		ApplicationContext context = SpringApplication.run(UsejpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		User user = new User();
		user.setName("Shilpa Dutta");
		user.setCity("Bankura");
		user.setStatus("Learning Node");
		userRepository.save(user);

		// Read

		// Fetching the saved user
		User savedUser = userRepository.findById(user.getId()).orElse(null);

		// Printing the saved user details
		if (savedUser != null) {
			System.out.println("Saved User Details:");
			System.out.println("ID: " + savedUser.getId());
			System.out.println("Name: " + savedUser.getName());
			System.out.println("City: " + savedUser.getCity());
			System.out.println("Status: " + savedUser.getStatus());
		} else {
			System.out.println("Failed to retrieve saved user.");
		}

		// Update
		savedUser.setCity("Mumbai");
		savedUser.setName("Subhadip kundu");
		userRepository.save(savedUser);
	}
}

package com.startingjpa.usejpa;

import org.springframework.context.ApplicationContext;

import com.startingjpa.usejpa.entities.User;
import com.startingjpa.usejpa.dao.FetchAsRequired;
import com.startingjpa.usejpa.dao.UserRepository;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsejpaApplication {

	public static void main(String[] args) {

		// Create

		ApplicationContext context = SpringApplication.run(UsejpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		FetchAsRequired fetchAsRequired = context.getBean(FetchAsRequired.class);
		fetchAsRequired.fetchUsers();

		User user = new User();
		user.setName("Shilpa Dutta");
		user.setCity("Bankura");
		user.setStatus("Learning Node");
		userRepository.save(user);

		// Read

		// Fetching the saved user
		User savedUser = userRepository.findById(1).orElse(null);

		/*
		 * 
		 * // Printing the saved user details
		 * if (savedUser != null) {
		 * System.out.println("Saved User Details:");
		 * System.out.println("ID: " + savedUser.getId());
		 * System.out.println("Name: " + savedUser.getName());
		 * System.out.println("City: " + savedUser.getCity());
		 * System.out.println("Status: " + savedUser.getStatus());
		 * } else {
		 * System.out.println("Failed to retrieve saved user.");
		 * }
		 * 
		 */

		// Fetch All
		Iterable<User> itr = userRepository.findAll();
		Iterator<User> iterator = itr.iterator();

		System.out.println("|   ID   |        Name        |      City      |         Status         |");
		while (iterator.hasNext()) {
			User u = iterator.next();
			System.out.printf("| %-7d| %-19s| %-15s| %-23s|\n", u.getId(), u.getName(), u.getCity(), u.getStatus());
		}
		System.out.println("|--------|--------------------|----------------|------------------------|");

		// Update
		savedUser.setCity("Mumbai");
		savedUser.setName("Subhadip kundu");
		userRepository.save(savedUser);

		// Delete
		userRepository.deleteById(11);
		System.out.println(user);
		System.out.println("DELETED");

		

	}
}

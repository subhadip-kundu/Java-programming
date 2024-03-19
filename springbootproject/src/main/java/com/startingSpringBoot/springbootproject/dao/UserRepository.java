package com.startingSpringBoot.springbootproject.dao;

import com.startingSpringBoot.springbootproject.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}

package com.startingjpa.usejpa.dao;

import org.springframework.data.repository.CrudRepository;
import com.startingjpa.usejpa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}

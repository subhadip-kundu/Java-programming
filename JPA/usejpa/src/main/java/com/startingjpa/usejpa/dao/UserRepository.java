package com.startingjpa.usejpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.startingjpa.usejpa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {


    // Custom way to fetch data by different query as per needed
    public List<User> findByName(String name);

    public List<User> findByNameAndCity(String name,String city);
}

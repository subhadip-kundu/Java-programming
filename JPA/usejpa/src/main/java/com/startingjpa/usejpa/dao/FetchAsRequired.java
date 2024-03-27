package com.startingjpa.usejpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.startingjpa.usejpa.entities.User;

import java.util.List;

@Component
public class FetchAsRequired {
    @Autowired
    private ApplicationContext context;

    public void fetchUsers() {
        UserRepository userRepository = context.getBean(UserRepository.class);

        List<User> usersByName = userRepository.findByName("subhadip kundu");

        usersByName.forEach(e -> System.out.println(e.getCity()));

        List<User> usersByCityAndName = userRepository.findByNameAndCity("Subhadip kundu", "Mumbai");
        usersByCityAndName.forEach(e -> System.out.println(e.getCity()));

        /* 

        *************************** SOME MORE CUSTOM FINDER METHOD *********************************

         * // Find products by name containing a certain keyword
         * List<Product> findByNameContaining(String keyword);
         * 
         * // Find products by price less than a certain value
         * List<Product> findByPriceLessThan(double value);
         * 
         * // Find products by category and price less than a certain value
         * List<Product> findByCategoryAndPriceLessThan(String category, double value);
         * 
         * // Find products by category or name containing a certain keyword
         * List<Product> findByCategoryOrNameContaining(String category, String
         * keyword);
         * 
         * // Find products ordered by name
         * List<Product> findByOrderByName();
         * 
         * // Find products by name starting with a certain prefix
         * List<Product> findByNameStartingWith(String prefix);
         */
    }
}

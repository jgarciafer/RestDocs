package com.boogastudio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boogastudio.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName);
} 

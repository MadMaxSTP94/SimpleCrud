package com.rest40.demo.repository;

import com.rest40.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

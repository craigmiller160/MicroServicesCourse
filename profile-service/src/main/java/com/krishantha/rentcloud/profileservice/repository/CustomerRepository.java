package com.krishantha.rentcloud.profileservice.repository;

import com.krishantha.rentcloud.profileservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }

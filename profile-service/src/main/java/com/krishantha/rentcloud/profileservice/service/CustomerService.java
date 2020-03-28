package com.krishantha.rentcloud.profileservice.service;

import com.krishantha.rentcloud.profileservice.model.Customer;
import com.krishantha.rentcloud.profileservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(final Customer customer) {
        return this.customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(final Long customerId) {
        return this.customerRepository.findById(customerId);
    }

}

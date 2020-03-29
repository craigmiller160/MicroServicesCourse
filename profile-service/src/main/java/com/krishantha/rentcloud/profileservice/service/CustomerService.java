package com.krishantha.rentcloud.profileservice.service;

import com.krishantha.rentcloud.profileservice.model.Customer;
import com.krishantha.rentcloud.profileservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(final Customer customer) {
        customer.setCustomerId(null);
        return this.customerRepository.save(customer);
    }

    public Optional<Customer> update(final Long id, final Customer customer) {
        customer.setCustomerId(id);
        return customerRepository.findById(id)
                .map(existing -> customerRepository.save(customer));
    }

    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    public Optional<Customer> get(final Long customerId) {
        return this.customerRepository.findById(customerId);
    }

}

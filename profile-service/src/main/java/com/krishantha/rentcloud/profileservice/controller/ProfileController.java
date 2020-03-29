package com.krishantha.rentcloud.profileservice.controller;

import com.krishantha.rentcloud.profileservice.model.Customer;
import com.krishantha.rentcloud.profileservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ProfileController {

    private final CustomerService customerService;

    public ProfileController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer createCustomer(@RequestBody final Customer customer) {
        return this.customerService.create(customer);
    }

    @PutMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('update_profile')")
    public ResponseEntity<Customer> updateCustomer(@PathVariable final Long id, @RequestBody final Customer customer) {
        return customerService.update(id, customer)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/customer")
    @PreAuthorize("hasAuthority('read_profile')")
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('read_profile')")
    public ResponseEntity<Customer> getCustomer(@PathVariable final Long id) {
        return customerService.get(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}

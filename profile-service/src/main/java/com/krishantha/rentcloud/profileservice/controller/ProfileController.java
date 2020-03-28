package com.krishantha.rentcloud.profileservice.controller;

import com.krishantha.rentcloud.profileservice.model.Customer;
import com.krishantha.rentcloud.profileservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ProfileController {

    private final CustomerService customerService;

    public ProfileController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody final Customer customer) {
        return this.customerService.save(customer);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable final Long id) {
        return customerService.getCustomer(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

}

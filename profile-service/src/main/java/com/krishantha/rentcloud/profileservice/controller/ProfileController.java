package com.krishantha.rentcloud.profileservice.controller;

import com.krishantha.rentcloud.profileservice.model.Customer;
import com.krishantha.rentcloud.profileservice.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

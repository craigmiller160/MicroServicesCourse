package com.krishantha.rentcloud.authcodeflowui.controller;

import com.krishantha.rentcloud.authcodeflowui.model.Customer;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Controller
public class ServiceController {

    private final RestTemplate restTemplate;

    public ServiceController(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/customers")
    public String loadCustomers(final Model model) {
        try {
            final ResponseEntity<Customer[]> responseEntity = restTemplate.getForEntity("http://localhost:8081/services/customer", Customer[].class);
            model.addAttribute("customers", responseEntity.getBody());
        } catch (HttpStatusCodeException ex) {
            final ResponseEntity responseEntity = ResponseEntity.status(ex.getRawStatusCode()).headers(ex.getResponseHeaders()).body(ex.getResponseBodyAsString());
            model.addAttribute("error", responseEntity);
        }
        return "secure";
    }

}

package com.krishantha.rentcloud.authcodeflowui.model;

import lombok.Data;

@Data
public class Customer {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String dlNumber;
    private String zipCode;
}

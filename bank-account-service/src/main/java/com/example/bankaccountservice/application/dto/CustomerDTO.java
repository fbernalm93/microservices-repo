package com.example.bankaccountservice.application.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String phoneNumber;
    private String password;
    private Boolean state;
}
package com.example.clientservice.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "customerId")
public class Customer extends Person {
    @NotEmpty(message="Field is required")
    @Column(name="password")
    private String password;
    @Column(name="state")
    private Boolean state;

    public Customer(String id, String name, Gender gender, Integer age, String address, String phoneNumber, String password, Boolean state) {
        super(id, name, gender, age, address, phoneNumber);
        this.password = password;
        this.state = state;
    }

    public Customer() {}
}

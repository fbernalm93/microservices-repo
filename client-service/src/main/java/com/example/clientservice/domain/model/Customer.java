package com.example.clientservice.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends Person {
    @Id
    @NotEmpty(message="Field is required")
    @Column(name="customerId")
    private Long customerId;
    @NotEmpty(message="Field is required")
    @Column(name="password")
    private String password;
    @NotEmpty(message="Field is required")
    @Column(name="state")
    private Boolean state;
}

package com.example.clientservice.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void testCustomerConstructorAndGetters() {
        String id = "0302195177";
        String name = "Franklin Bernal";
        Gender gender = Gender.MASCULINO;
        Integer age = 31;
        String address = "Cacique Chaparra 5-51";
        String phoneNumber = "0979100036";
        String password = "claveTemporalFbernal";
        Boolean state = true;

        Customer customer = new Customer(id, name, gender, age, address, phoneNumber, password, state);

        assertEquals(id, customer.getId());
        assertEquals(name, customer.getName());
        assertEquals(gender, customer.getGender());
        assertEquals(age, customer.getAge());
        assertEquals(address, customer.getAddress());
        assertEquals(phoneNumber, customer.getPhoneNumber());
        assertEquals(password, customer.getPassword());
        assertEquals(state, customer.getState());
    }

}

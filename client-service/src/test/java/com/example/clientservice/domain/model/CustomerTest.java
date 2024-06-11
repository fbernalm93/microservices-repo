package com.example.clientservice.domain.model;

import com.example.clientservice.domain.model.Customer;
import com.example.clientservice.domain.model.Gender;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomerTest {

    @Test
    public void testCustomerConstructorAndGetters() {
        String id = "0302195177";
        String name = "Franklin Bernal";
        Gender gender = Gender.MALE;
        Integer age = 31;
        String address = "Cacique Chaparra 5-51";
        String phoneNumber = "0979100036";
        Long customerId = 1L;
        String password = "claveTemporalFbernal";
        Boolean state = true;

        Customer customer = new Customer(id, name, gender, age, address, phoneNumber, customerId, password, state);

        assertEquals(id, customer.getId());
        assertEquals(name, customer.getName());
        assertEquals(gender, customer.getGender());
        assertEquals(age, customer.getAge());
        assertEquals(address, customer.getAddress());
        assertEquals(phoneNumber, customer.getPhoneNumber());
        assertEquals(customerId, customer.getCustomerId());
        assertEquals(password, customer.getPassword());
        assertEquals(state, customer.getState());
    }

}

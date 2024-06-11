package com.example.clientservice.application.service;

import com.example.clientservice.domain.model.Customer;
import com.example.clientservice.domain.model.Gender;
import com.example.clientservice.domain.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testGetCustomerById() {
        String customerId = "0302195177";
        Customer mockCustomer = new Customer("0302195177", "Franklin Bernal", Gender.MASCULINO, 30, "Cacique Chaparra", "0979100036", "password123", true);

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));

        Customer retrievedCustomer = customerService.getCustomerById(customerId).orElse(null);

        assertEquals(mockCustomer, retrievedCustomer);
        verify(customerRepository, times(1)).findById(customerId);
    }

}
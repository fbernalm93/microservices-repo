package com.example.bankaccountservice.application.client;

import com.example.bankaccountservice.application.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String CUSTOMER_SERVICE_URL = "http://localhost:8081/clientes";

    public CustomerDTO getCustomerById(String customerId) {
        return restTemplate.getForObject(CUSTOMER_SERVICE_URL + "/" + customerId, CustomerDTO.class);
    }
}

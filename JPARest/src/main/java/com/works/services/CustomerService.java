package com.works.services;

import com.works.entities.Customer;
import com.works.repositories.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;
    final HttpServletRequest request;

    public Customer customerLogin( Customer customer ) {
        Optional<Customer> customerOptional = customerRepository.customerLogin(customer.getEmail(), customer.getPassword());
        if (customerOptional.isPresent()) {
            Customer c  = customerOptional.get();
            c.setPassword(null);
            request.getSession().setAttribute("customer", c);
            return c;
        }
        return null;
    }


}

package com.example.demo.Service.Customer;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getByid(long id) {
        return customerRepository.findById(id).orElse(null);
    }
}

package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.entity.CustomerDetails;
import com.agency04.sbss.pizza.error.NotFoundException;
import com.agency04.sbss.pizza.repository.CustomerDetailsRepository;
import com.agency04.sbss.pizza.service.CustomerDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
    private final CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetailsServiceImpl(CustomerDetailsRepository customerDetailsRepository) {
        this.customerDetailsRepository = customerDetailsRepository;
    }

    @Override
    public void save(CustomerDetails customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }

    @Override
    public CustomerDetails get(Long id) {
        return customerDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("get error, customer details not found"));
    }

    @Override
    public List<CustomerDetails> getAll() {
        return customerDetailsRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        customerDetailsRepository.delete(customerDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("delete error, customer details not found")));
    }
}

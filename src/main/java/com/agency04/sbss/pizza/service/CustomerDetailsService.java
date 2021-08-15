package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.entity.CustomerDetails;

import java.util.List;

public interface CustomerDetailsService {
    void save(CustomerDetails customerDetails);

    CustomerDetails get(Long id);

    List<CustomerDetails> getAll();

    void delete(Long id);
}

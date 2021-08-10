package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    Customer get(String username);

    List<Customer> getAll();

    void delete(String username);
}

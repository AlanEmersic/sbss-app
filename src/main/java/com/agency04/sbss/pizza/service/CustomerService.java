package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.dto.CustomerDto;
import com.agency04.sbss.pizza.form.CustomerForm;

import java.util.List;

public interface CustomerService {
    void save(CustomerForm customerForm);

    CustomerDto get(String username);

    List<CustomerDto> getAll();

    void delete(String username);

    CustomerDto update(CustomerForm customerForm);
}

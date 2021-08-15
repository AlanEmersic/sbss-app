package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.entity.Customer;
import com.agency04.sbss.pizza.error.NotFoundException;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer get(String username) {
        return customerRepository.findCustomerByUsername(username)
                .orElseThrow(() -> new NotFoundException("get error, customer not found"));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(String username) {
        customerRepository.delete(customerRepository.findCustomerByUsername(username)
                .orElseThrow(() -> new NotFoundException("delete error, customer not found")));
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByUsername(customer.getUsername());

        if (optionalCustomer.isPresent()) {
            Customer updateCustomer = optionalCustomer.get();
            BeanUtils.copyProperties(customer, updateCustomer);
            customerRepository.save(updateCustomer);
            return updateCustomer;
        } else {
            throw new NotFoundException("update error, customer not found");
        }
    }
}

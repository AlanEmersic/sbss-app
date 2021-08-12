package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.error.RestControllerNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customers;

    @PostConstruct
    private void loadData() {
        customers = new ArrayList<>();
        customers.add(new Customer("iivic", "Ivo", "Ivić"));
        customers.add(new Customer("ihorvat", "Ivan", "Horvat"));
        customers.add(new Customer("abanana", "Ana", "banana"));
        customers.add(new Customer("pperic", "Pero", "Perić"));
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer get(String username) {
        Customer findCustomer = customers.stream().
                filter(c -> c.getUsername().equals(username)).findFirst().orElse(null);

        if (Objects.nonNull(findCustomer)) {
            return findCustomer;
        } else {
            throw new RestControllerNotFoundException("customer with username: " + username + " not found");
        }
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public void delete(String username) {
        Customer customer = customers.stream().filter(c -> c.getUsername().equals(username)).findFirst().orElse(null);

        if (Objects.nonNull(customer)) {
            customers.remove(customer);
        } else {
            throw new RestControllerNotFoundException("customer with username: " + username + " not found");
        }
    }

    @Override
    public Customer update(Customer customer) {
        Customer findCustomer = customers.stream().
                filter(c -> c.getUsername().equals(customer.getUsername())).findFirst().orElse(null);

        if (Objects.nonNull(findCustomer)) {
            customers.set(customers.indexOf(findCustomer), customer);
            return findCustomer;
        } else {
            throw new RestControllerNotFoundException("customer not found");
        }
    }
}

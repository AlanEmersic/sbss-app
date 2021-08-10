package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Customer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private List<Customer> customers;

    @PostConstruct
    private void loadData() {
        customers = new ArrayList<>();
        customers.add(new Customer("iivic", "Ivo", "Ivić"));
        customers.add(new Customer("ihorvat", "Ivan", "Horvat"));
        customers.add(new Customer("abanana", "Ana", "banana"));
        customers.add(new Customer("pperic", "Pero", "Perić"));
    }

    @GetMapping("/all")
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable final String username) {
        return customers.stream().filter(customer -> customer.getUsername().equals(username)).findFirst().get();
    }

    @PostMapping
    public void addCustomer(@RequestBody final Customer customer) {
        customers.add(customer);
    }

    @PutMapping
    public Customer update(@RequestBody final Customer customer) {
        Customer findCustomer = customers.stream().
                filter(c -> c.getUsername().equals(customer.getUsername())).findFirst().orElse(null);

        if (Objects.nonNull(findCustomer)) {
            customers.set(customers.indexOf(findCustomer),customer);
        }

        return customer;
    }

    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username) {
        Customer customer = customers.stream().filter(c -> c.getUsername().equals(username)).findFirst().orElse(null);
        customers.remove(customer);
    }
}

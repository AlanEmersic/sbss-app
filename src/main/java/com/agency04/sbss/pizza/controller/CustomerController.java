package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable final String username) {
        return customerService.get(username);
    }

    @PostMapping
    public void addCustomer(@RequestBody final Customer customer) {
        customerService.save(customer);
    }

    @PutMapping
    public Customer update(@RequestBody final Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username) {
        customerService.delete(username);
    }
}

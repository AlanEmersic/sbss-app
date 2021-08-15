package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.entity.CustomerDetails;
import com.agency04.sbss.pizza.service.CustomerDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-details")
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;

    public CustomerDetailsController(CustomerDetailsService customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }

    @GetMapping
    public List<CustomerDetails> getAll() {
        return customerDetailsService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDetails get(@PathVariable Long id) {
        return customerDetailsService.get(id);
    }

    @PostMapping
    public void create(@RequestBody CustomerDetails customerDetails) {
        customerDetailsService.save(customerDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerDetailsService.delete(id);
    }
}

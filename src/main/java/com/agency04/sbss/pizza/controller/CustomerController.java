package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.dto.CustomerDto;
import com.agency04.sbss.pizza.form.CustomerForm;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<CustomerDto> getCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/{username}")
    public CustomerDto getCustomer(@PathVariable final String username) {
        return customerService.get(username);
    }

    @PostMapping
    public void addCustomer(@Valid @RequestBody final CustomerForm customerForm) {
        customerService.save(customerForm);
    }

    @PutMapping
    public CustomerDto update(@Valid @RequestBody final CustomerForm customerForm) {
        return customerService.update(customerForm);
    }

    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username) {
        customerService.delete(username);
    }
}

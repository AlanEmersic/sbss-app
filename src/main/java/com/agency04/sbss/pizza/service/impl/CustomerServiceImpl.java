package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.dto.CustomerDto;
import com.agency04.sbss.pizza.entity.Customer;
import com.agency04.sbss.pizza.entity.CustomerDetails;
import com.agency04.sbss.pizza.error.NotFoundException;
import com.agency04.sbss.pizza.form.CustomerForm;
import com.agency04.sbss.pizza.mapper.CustomerDtoMapper;
import com.agency04.sbss.pizza.repository.CustomerDetailsRepository;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoMapper customerDtoMapper;
    private final CustomerDetailsRepository customerDetailsRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerDtoMapper customerDtoMapper,
                               CustomerDetailsRepository customerDetailsRepository) {
        this.customerRepository = customerRepository;
        this.customerDtoMapper = customerDtoMapper;
        this.customerDetailsRepository = customerDetailsRepository;
    }

    @Override
    public void save(CustomerForm customerForm) {
        if (customerForm.getDetails().getFirstName().trim().isEmpty() ||
                customerForm.getDetails().getLastName().trim().isEmpty() ||
                customerForm.getDetails().getPhone().trim().isEmpty()
        ) {
            throw new RuntimeException("Validate exception for customer form");
        }

        Customer customer = new Customer();
        CustomerDetails customerDetails = new CustomerDetails();
        BeanUtils.copyProperties(customerForm.getDetails(), customerDetails);
        customerDetails.setCustomer(customer);
        BeanUtils.copyProperties(customerForm, customer);
        customer.setCustomerDetails(customerDetails);
        customerRepository.save(customer);
        customerDetailsRepository.save(customerDetails);
    }

    @Override
    public CustomerDto get(String username) {
        return customerDtoMapper.map(customerRepository.findCustomerByUsername(username)
                .orElseThrow(() -> new NotFoundException("get error, customer not found")));
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream().map(customerDtoMapper::map).collect(Collectors.toList());
    }

    @Override
    public void delete(String username) {
        customerRepository.delete(customerRepository.findCustomerByUsername(username)
                .orElseThrow(() -> new NotFoundException("delete error, customer not found")));
    }

    @Override
    public CustomerDto update(CustomerForm customerForm) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByUsername(customerForm.getUsername());

        if (optionalCustomer.isPresent()) {
            Customer updateCustomer = optionalCustomer.get();
            BeanUtils.copyProperties(customerForm, updateCustomer);
            customerRepository.save(updateCustomer);
            return customerDtoMapper.map(updateCustomer);
        } else {
            throw new NotFoundException("update error, customer not found");
        }
    }
}

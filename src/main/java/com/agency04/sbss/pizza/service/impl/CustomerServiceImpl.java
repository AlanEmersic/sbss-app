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
import java.util.stream.Stream;

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
        if (Stream
                .of(customerForm.getDetails().getFirstName(),
                        customerForm.getDetails().getLastName(),
                        customerForm.getDetails().getPhone())
                .anyMatch(String::isEmpty)) {
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
        return customerDtoMapper.map(customerRepository.findTopByUsername(username)
                .orElseThrow(() -> new NotFoundException("get error, customer not found")));
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream().map(customerDtoMapper::map).collect(Collectors.toList());
    }

    @Override
    public void delete(String username) {
        customerRepository.delete(customerRepository.findTopByUsername(username)
                .orElseThrow(() -> new NotFoundException("delete error, customer not found")));
    }

    @Override
    public CustomerDto update(CustomerForm customerForm) {
        Optional<Customer> optionalCustomer = customerRepository.findTopByUsername(customerForm.getUsername());

        if (optionalCustomer.isPresent()) {
            Customer updateCustomer = optionalCustomer.get();
            CustomerDetails customerDetails = customerDetailsRepository
                    .findTopByCustomer_Username(updateCustomer.getUsername()).get();
            updateCustomer.setCustomerDetails(customerDetails);
            BeanUtils.copyProperties(customerForm.getDetails(), customerDetails);
            customerDetailsRepository.save(customerDetails);
            return customerDtoMapper.map(updateCustomer);
        } else {
            throw new NotFoundException("update error, customer not found");
        }
    }
}

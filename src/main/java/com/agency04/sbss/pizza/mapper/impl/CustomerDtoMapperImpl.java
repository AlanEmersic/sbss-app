package com.agency04.sbss.pizza.mapper.impl;

import com.agency04.sbss.pizza.dto.CustomerDto;
import com.agency04.sbss.pizza.entity.Customer;
import com.agency04.sbss.pizza.mapper.CustomerDetailsDtoMapper;
import com.agency04.sbss.pizza.mapper.CustomerDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerDtoMapperImpl implements CustomerDtoMapper {
    private final CustomerDetailsDtoMapper customerDetailsDtoMapper;

    public CustomerDtoMapperImpl(CustomerDetailsDtoMapper customerDetailsDtoMapper) {
        this.customerDetailsDtoMapper = customerDetailsDtoMapper;
    }

    @Override
    public CustomerDto map(Customer customer) {
        if (Objects.isNull(customer))
            return null;

        CustomerDto dto = new CustomerDto();
        dto.setUsername(customer.getUsername());
        dto.setDetails(customerDetailsDtoMapper.map(customer.getCustomerDetails()));

        return dto;
    }
}

package com.agency04.sbss.pizza.mapper;

import com.agency04.sbss.pizza.dto.CustomerDto;
import com.agency04.sbss.pizza.entity.Customer;

public interface CustomerDtoMapper {
    CustomerDto map(Customer customer);
}

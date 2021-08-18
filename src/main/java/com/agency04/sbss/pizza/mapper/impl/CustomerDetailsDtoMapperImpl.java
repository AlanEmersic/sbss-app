package com.agency04.sbss.pizza.mapper.impl;

import com.agency04.sbss.pizza.dto.CustomerDetailsDto;
import com.agency04.sbss.pizza.entity.CustomerDetails;
import com.agency04.sbss.pizza.mapper.CustomerDetailsDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerDetailsDtoMapperImpl implements CustomerDetailsDtoMapper {
    @Override
    public CustomerDetailsDto map(CustomerDetails customerDetails) {
        if (Objects.isNull(customerDetails))
            return null;

        CustomerDetailsDto dto = new CustomerDetailsDto();
        dto.setFirstName(customerDetails.getFirstName());
        dto.setLastName(customerDetails.getLastName());
        dto.setPhone(customerDetails.getPhone());

        return dto;
    }
}

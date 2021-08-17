package com.agency04.sbss.pizza.mapper;

import com.agency04.sbss.pizza.dto.CustomerDetailsDto;
import com.agency04.sbss.pizza.entity.CustomerDetails;

public interface CustomerDetailsDtoMapper {
    CustomerDetailsDto map(CustomerDetails customerDetails);
}

package com.agency04.sbss.pizza.mapper.impl;

import com.agency04.sbss.pizza.dto.DeliveryDto;
import com.agency04.sbss.pizza.entity.Delivery;
import com.agency04.sbss.pizza.mapper.CustomerDtoMapper;
import com.agency04.sbss.pizza.mapper.DeliveryDtoMapper;
import com.agency04.sbss.pizza.mapper.PizzaOrderDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DeliveryDtoMapperImpl implements DeliveryDtoMapper {
    private final CustomerDtoMapper customerDtoMapper;
    private final PizzaOrderDtoMapper pizzaOrderDtoMapper;

    public DeliveryDtoMapperImpl(CustomerDtoMapper customerDtoMapper, PizzaOrderDtoMapper pizzaOrderDtoMapper) {
        this.customerDtoMapper = customerDtoMapper;
        this.pizzaOrderDtoMapper = pizzaOrderDtoMapper;
    }


    @Override
    public DeliveryDto map(Delivery delivery) {
        if (Objects.isNull(delivery))
            return null;

        DeliveryDto dto = new DeliveryDto();
        dto.setCustomer(customerDtoMapper.map(delivery.getCustomer()));
        dto.setOrders(delivery.getPizzaOrders().stream().map(pizzaOrderDtoMapper::map).collect(Collectors.toList()));
        dto.setSubmissionDate(delivery.getSubmissionDate());

        return dto;
    }
}

package com.agency04.sbss.pizza.mapper.impl;

import com.agency04.sbss.pizza.dto.PizzaOrderDto;
import com.agency04.sbss.pizza.entity.PizzaOrder;
import com.agency04.sbss.pizza.mapper.PizzaDtoMapper;
import com.agency04.sbss.pizza.mapper.PizzaOrderDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PizzaOrderDtoMapperImpl implements PizzaOrderDtoMapper {
    private final PizzaDtoMapper pizzaDtoMapper;

    public PizzaOrderDtoMapperImpl(PizzaDtoMapper pizzaDtoMapper) {
        this.pizzaDtoMapper = pizzaDtoMapper;
    }

    @Override
    public PizzaOrderDto map(PizzaOrder pizzaOrder) {
        if (Objects.isNull(pizzaOrder))
            return null;

        PizzaOrderDto dto = new PizzaOrderDto();
        dto.setSize(pizzaOrder.getSize());
        dto.setQuantity(pizzaOrder.getQuantity());
        dto.setPizza(pizzaDtoMapper.map(pizzaOrder.getPizza()));

        return dto;
    }
}

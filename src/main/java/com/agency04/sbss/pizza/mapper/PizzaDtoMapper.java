package com.agency04.sbss.pizza.mapper;

import com.agency04.sbss.pizza.dto.PizzaDto;
import com.agency04.sbss.pizza.entity.Pizza;

public interface PizzaDtoMapper {
    PizzaDto map(Pizza pizza);
}

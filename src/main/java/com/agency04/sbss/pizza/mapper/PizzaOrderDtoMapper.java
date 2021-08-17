package com.agency04.sbss.pizza.mapper;

import com.agency04.sbss.pizza.dto.PizzaOrderDto;
import com.agency04.sbss.pizza.entity.PizzaOrder;

public interface PizzaOrderDtoMapper {
    PizzaOrderDto map(PizzaOrder pizzaOrder);
}

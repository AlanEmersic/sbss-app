package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.dto.PizzaOrderDto;

import java.util.List;

public interface PizzaOrderService {

    PizzaOrderDto get(Long id);

    List<PizzaOrderDto> getAll();
}

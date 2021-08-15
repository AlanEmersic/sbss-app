package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.entity.PizzaOrder;

import java.util.List;

public interface PizzaOrderService {
    void save(PizzaOrder order);

    PizzaOrder get(Long id);

    List<PizzaOrder> getAll();

    void delete(Long id);
}

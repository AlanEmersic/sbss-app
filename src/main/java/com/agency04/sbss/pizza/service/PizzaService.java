package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.entity.Pizza;

import java.util.List;

public interface PizzaService {
    void save(Pizza pizza);

    Pizza get(Long id);

    List<Pizza> getAll();

    void delete(Long id);
}

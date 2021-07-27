package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaDelivery implements PizzaDeliveryService {
    private final PizzeriaService pizzeriaService;

    @Autowired
    public PizzaDelivery(@Qualifier("pizzeria") PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @Override
    public String orderPizza(Pizza pizza) {
        return "PizzaDelivery order";
    }
}

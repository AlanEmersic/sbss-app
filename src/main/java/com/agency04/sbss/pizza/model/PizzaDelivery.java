package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;

public class PizzaDelivery implements PizzaDeliveryService {
    private final PizzeriaService pizzeriaService;

    public PizzaDelivery(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @Override
    public String orderPizza(Pizza pizza) {
        return "PizzaDelivery order";
    }
}

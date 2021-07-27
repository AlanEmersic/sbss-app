package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;

public class PizzaDelivery2 implements PizzaDeliveryService {
    private PizzeriaService pizzeriaService;

    @Override
    public String orderPizza(Pizza pizza) {
        return "PizzaDelivery2 order";
    }

    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }
}

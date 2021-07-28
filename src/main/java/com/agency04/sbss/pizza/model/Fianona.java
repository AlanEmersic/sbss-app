package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;

public class Fianona implements PizzaDeliveryService {
    private final PizzeriaService pizzeriaService;

    @Autowired
    public Fianona(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @Override
    public String orderPizza(Pizza pizza) {
        return "Fianona order";
    }
}

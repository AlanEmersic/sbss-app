package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaDelivery2 implements PizzaDeliveryService {
    private PizzeriaService pizzeriaService;

    @Override
    public String orderPizza(Pizza pizza) {
        return "PizzaDelivery2 order";
    }

    @Autowired
    public void setPizzeriaService(@Qualifier("pizzeria2") PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }
}

package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Capuciner implements PizzaDeliveryService {
    private PizzeriaService pizzeriaService;

    @Override
    public String orderPizza(Pizza pizza) {
        return "Capuciner order";
    }

    @Autowired
    public void setPizzeriaService(@Qualifier("pizzeriaLira") PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }
}

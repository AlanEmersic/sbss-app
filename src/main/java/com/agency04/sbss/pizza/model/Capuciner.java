package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDate;

@Service
public class Capuciner implements PizzaDeliveryService {
    private PizzeriaService pizzeriaService;
    private LocalDate deliveryDate;

    @Override
    public String orderPizza(Pizza pizza) {
        return "Order from " + pizzeriaService.getName();
    }

    @Autowired
    public void setPizzeriaService(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @PostConstruct
    public void doStartup() {
        System.out.println("Capuciner in doStartup method");
        deliveryDate = LocalDate.now();
        System.out.println("Delivery date: " + deliveryDate);
    }

    @PreDestroy
    public void doCleanup() {
        System.out.println("Capuciner in doCleanup method");
    }
}

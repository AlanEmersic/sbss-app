package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/capuciner")
public class CapucinerController {

    private final PizzaDeliveryService pizzaDeliveryService;
    private List<DeliveryOrderForm> orders;

    public CapucinerController(@Qualifier("capuciner") PizzaDeliveryService pizzaDeliveryService) {
        this.pizzaDeliveryService = pizzaDeliveryService;
        orders = new ArrayList<>();
    }

    @GetMapping("/list")
    public List<DeliveryOrderForm> getList() {
        return orders;
    }

    @PostMapping("/order")
    public void addOrder(@RequestBody final DeliveryOrderForm order) {
        orders.add(order);
    }
}

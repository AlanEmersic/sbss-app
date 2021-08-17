package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.dto.PizzaOrderDto;
import com.agency04.sbss.pizza.service.PizzaOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaController {

    private final PizzaOrderService pizzaOrderService;

    public PizzeriaController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping("/menu")
    public List<PizzaOrderDto> getMenu() {
        return pizzaOrderService.getAll();
    }

    @GetMapping("/{id}")
    public PizzaOrderDto getOrder(@PathVariable final Long id) {
        return pizzaOrderService.get(id);
    }
}

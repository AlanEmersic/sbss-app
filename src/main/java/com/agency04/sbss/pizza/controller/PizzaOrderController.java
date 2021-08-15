package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.entity.PizzaOrder;
import com.agency04.sbss.pizza.service.PizzaOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping
    public List<PizzaOrder> getAll() {
        return pizzaOrderService.getAll();
    }

    @GetMapping("/{id}")
    public PizzaOrder get(@PathVariable Long id) {
        return pizzaOrderService.get(id);
    }

    @PostMapping
    public void create(@RequestBody PizzaOrder order) {
        pizzaOrderService.save(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pizzaOrderService.delete(id);
    }
}

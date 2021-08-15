package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.entity.Pizza;
import com.agency04.sbss.pizza.service.PizzaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<Pizza> getAll() {
        return pizzaService.getAll();
    }

    @GetMapping("/{id}")
    public Pizza get(@PathVariable Long id) {
        return pizzaService.get(id);
    }

    @PostMapping
    public void create(@RequestBody Pizza pizza) {
        pizzaService.save(pizza);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pizzaService.delete(id);
    }
}

package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Marinara;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaSize;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/chello")
public class PizzeriaChelloController {

    private final PizzeriaService pizzeriaService;
    private List<Pizza> pizzas;

    public PizzeriaChelloController(PizzeriaService pizzeriaService) {
        this.pizzeriaService = pizzeriaService;
    }

    @PostConstruct
    private void loadData() {
        pizzas = new ArrayList<>();
        pizzas.add(new Margherita(PizzaSize.SMALL));
        pizzas.add(new Margherita(PizzaSize.MEDIUM));
        pizzas.add(new Marinara(PizzaSize.LARGE));
    }

    @GetMapping("/menu")
    public List<Pizza> getMenu() {
        return pizzas;
    }

    @GetMapping()
    public PizzeriaService getPizzeria() {
        return this.pizzeriaService;
    }
}

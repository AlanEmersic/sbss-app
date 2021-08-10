package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.model.PizzeriaChello;
import com.agency04.sbss.pizza.model.PizzeriaLira;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaController {

    private List<PizzeriaService> pizzerias;

    @PostConstruct
    private void loadData() {
        pizzerias = new ArrayList<>();
        pizzerias.add(new PizzeriaLira());
        pizzerias.add(new PizzeriaChello());
    }


    public PizzeriaChello getPizzeria(@PathVariable int id) {
        return null;
    }

    @GetMapping("/pizzerias")
    public List<PizzeriaService> getPizzerias() {
        return pizzerias;
    }
}

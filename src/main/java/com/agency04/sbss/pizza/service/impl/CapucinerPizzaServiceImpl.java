package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.error.RestControllerNotFoundException;
import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.service.PizzaService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CapucinerPizzaServiceImpl implements PizzaService {
    private List<Pizza> pizzas;

    @PostConstruct
    private void loadData() {
        pizzas = new ArrayList<>();
        pizzas.add(new Margherita(PizzaSize.SMALL));
        pizzas.add(new Margherita(PizzaSize.MEDIUM));
        pizzas.add(new Marinara(PizzaSize.LARGE));
    }

    @Override
    public Pizza get(String name) {
        Pizza findPizza = pizzas.stream().
                filter(p -> p.getName().equals(name)).findFirst().orElse(null);

        if (Objects.nonNull(findPizza)) {
            return findPizza;
        } else {
            throw new RestControllerNotFoundException("pizza not found");
        }
    }
}

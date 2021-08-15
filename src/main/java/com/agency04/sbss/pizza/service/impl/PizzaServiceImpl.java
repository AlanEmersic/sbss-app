package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.entity.Pizza;
import com.agency04.sbss.pizza.error.NotFoundException;
import com.agency04.sbss.pizza.repository.PizzaRepository;
import com.agency04.sbss.pizza.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public void save(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    @Override
    public Pizza get(Long id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new NotFoundException("get error, pizza not found"));
    }

    @Override
    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        pizzaRepository.delete(pizzaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("delete error, pizza not found")));
    }
}

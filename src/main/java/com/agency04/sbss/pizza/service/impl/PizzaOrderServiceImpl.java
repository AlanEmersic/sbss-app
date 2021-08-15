package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.entity.PizzaOrder;
import com.agency04.sbss.pizza.error.NotFoundException;
import com.agency04.sbss.pizza.repository.PizzaOrderRepository;
import com.agency04.sbss.pizza.service.PizzaOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService {
    private final PizzaOrderRepository pizzaOrderRepository;

    public PizzaOrderServiceImpl(PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    @Override
    public void save(PizzaOrder order) {
        pizzaOrderRepository.save(order);
    }

    @Override
    public PizzaOrder get(Long id) {
        return pizzaOrderRepository.findById(id).orElseThrow(() -> new NotFoundException("get error, order not found"));
    }

    @Override
    public List<PizzaOrder> getAll() {
        return pizzaOrderRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        pizzaOrderRepository.delete(pizzaOrderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("delete error, order not found")));
    }
}

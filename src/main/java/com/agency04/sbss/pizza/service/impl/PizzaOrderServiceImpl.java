package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.dto.PizzaOrderDto;
import com.agency04.sbss.pizza.error.NotFoundException;
import com.agency04.sbss.pizza.mapper.PizzaOrderDtoMapper;
import com.agency04.sbss.pizza.repository.PizzaOrderRepository;
import com.agency04.sbss.pizza.service.PizzaOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService {
    private final PizzaOrderRepository pizzaOrderRepository;
    private final PizzaOrderDtoMapper pizzaOrderDtoMapper;

    public PizzaOrderServiceImpl(PizzaOrderRepository pizzaOrderRepository, PizzaOrderDtoMapper pizzaOrderDtoMapper) {
        this.pizzaOrderRepository = pizzaOrderRepository;
        this.pizzaOrderDtoMapper = pizzaOrderDtoMapper;
    }

    @Override
    public PizzaOrderDto get(Long id) {
        return pizzaOrderDtoMapper.map(pizzaOrderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("get error, order not found")));
    }

    @Override
    public List<PizzaOrderDto> getAll() {
        return pizzaOrderRepository.findAll().stream().map(pizzaOrderDtoMapper::map).collect(Collectors.toList());
    }
}

package com.agency04.sbss.pizza.mapper.impl;

import com.agency04.sbss.pizza.dto.PizzaDto;
import com.agency04.sbss.pizza.entity.Pizza;
import com.agency04.sbss.pizza.mapper.PizzaDtoMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PizzaDtoMapperImpl implements PizzaDtoMapper {
    @Override
    public PizzaDto map(Pizza pizza) {
        if (Objects.isNull(pizza))
            return null;

        PizzaDto dto = new PizzaDto();
        dto.setName(pizza.getName());
        dto.setIngredients(pizza.getIngredients());

        return dto;
    }
}

package com.agency04.sbss.pizza.dto;

import com.agency04.sbss.pizza.entity.Ingredient;
import lombok.Data;

import java.util.Set;

@Data
public class PizzaDto {
    private String name;
    private Set<Ingredient> ingredients;
}

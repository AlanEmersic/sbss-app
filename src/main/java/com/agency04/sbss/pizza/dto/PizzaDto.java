package com.agency04.sbss.pizza.dto;

import com.agency04.sbss.pizza.entity.Ingredient;
import lombok.Data;

@Data
public class PizzaDto {
    private String name;
    private Ingredient ingredients;
}

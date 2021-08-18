package com.agency04.sbss.pizza.dto;

import com.agency04.sbss.pizza.entity.PizzaSize;
import lombok.Data;

@Data
public class PizzaOrderDto {
    private String quantity;
    private PizzaSize size;
    private PizzaDto pizza;
}

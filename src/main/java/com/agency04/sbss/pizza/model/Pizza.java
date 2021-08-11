package com.agency04.sbss.pizza.model;

import java.util.Set;

public interface Pizza {
    String getName();

    Set<PizzaIngredient> getIngredients();

    PizzaSize getSize();
}

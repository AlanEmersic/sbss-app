package com.agency04.sbss.pizza.model;

import java.util.EnumSet;
import java.util.Set;

public class Marinara implements Pizza {
    @Override
    public String getName() {
        return "Marinara";
    }

    @Override
    public Set<PizzaIngredient> getIngredients() {
        return EnumSet.of(PizzaIngredient.TomatoSouce,
                PizzaIngredient.Garlic, PizzaIngredient.Basil);
    }
}

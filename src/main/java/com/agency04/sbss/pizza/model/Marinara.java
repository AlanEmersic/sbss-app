package com.agency04.sbss.pizza.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Marinara implements Pizza {
    @Override
    public String getName() {
        return "Marinara";
    }

    @Override
    public Set<PizzaIngredient> getIngredients() {
        return new HashSet<>(Arrays.asList(PizzaIngredient.TomatoSouce,
                PizzaIngredient.Garlic, PizzaIngredient.Basil));
    }
}

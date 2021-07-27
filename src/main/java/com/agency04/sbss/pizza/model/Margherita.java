package com.agency04.sbss.pizza.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Margherita implements Pizza {

    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public Set<PizzaIngredient> getIngredients() {
        return new HashSet<>(Arrays.asList(PizzaIngredient.TomatoSouce,
                PizzaIngredient.Mozzarella, PizzaIngredient.Oregano));

    }
}

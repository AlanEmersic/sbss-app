package com.agency04.sbss.pizza.model;

import java.util.EnumSet;
import java.util.Set;

public class Margherita implements Pizza {

    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public Set<PizzaIngredient> getIngredients() {
        return EnumSet.of(PizzaIngredient.TomatoSouce,
                PizzaIngredient.Mozzarella, PizzaIngredient.Oregano);
    }
}

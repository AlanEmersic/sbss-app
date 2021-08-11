package com.agency04.sbss.pizza.model;

import java.util.EnumSet;
import java.util.Set;

public class Margherita implements Pizza {
    private PizzaSize pizzaSize;

    public Margherita(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public Margherita() {
    }

    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public Set<PizzaIngredient> getIngredients() {
        return EnumSet.of(PizzaIngredient.TomatoSouce,
                PizzaIngredient.Mozzarella, PizzaIngredient.Oregano);
    }

    @Override
    public PizzaSize getSize() {
        return pizzaSize;
    }
}

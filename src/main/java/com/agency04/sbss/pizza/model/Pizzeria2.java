package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.service.PizzeriaService;

public class Pizzeria2 implements PizzeriaService {
    private String name;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return "Pizzeria2";
    }

    @Override
    public String getAddress() {
        return "Pizzeria2 address";
    }

    @Override
    public void makePizza(Pizza pizza) {

    }
}

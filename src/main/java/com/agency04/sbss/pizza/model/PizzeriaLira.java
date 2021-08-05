package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PizzeriaLira implements PizzeriaService {
    @Value("Pizzeria Lira")
    private String name;
    @Value("Pizzeria Lira address")
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String makePizza(Pizza pizza) {
        return pizza.getName();
    }
}

package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PizzeriaLira implements PizzeriaService {
    @Value("PizzeriaLira")
    private String name;
    @Value("PizzeriaLira address")
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

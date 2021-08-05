package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Fianona;
import com.agency04.sbss.pizza.model.PizzeriaChello;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PizzaConfig {

    public PizzeriaService pizzeriaService() {
        return new PizzeriaChello();
    }

    @Bean
    public PizzaDeliveryService fianona() {
        return new Fianona(pizzeriaService());
    }

}

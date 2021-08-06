package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.PizzeriaChello;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PizzaConfig {

    @Bean
    @Primary
    public PizzeriaService pizzeriaService() {
        return new PizzeriaChello();
    }
}

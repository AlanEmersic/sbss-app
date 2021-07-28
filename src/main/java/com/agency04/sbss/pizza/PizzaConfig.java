package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Capuciner;
import com.agency04.sbss.pizza.model.Fianona;
import com.agency04.sbss.pizza.model.PizzeriaChello;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.agency04.sbss.pizza")
@PropertySource("classpath:application.properties")
public class PizzaConfig {

    @Bean
    public PizzeriaService pizzeriaService() {
        return new PizzeriaChello();
    }

    @Bean
    public PizzaDeliveryService fianona() {
        return new Fianona(pizzeriaService());
    }

    @Bean
    public PizzaDeliveryService capuciner() {
        Capuciner capuciner = new Capuciner();
        capuciner.setPizzeriaService(pizzeriaService());
        return capuciner;
    }
}

package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Marinara;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        ConfigurableApplicationContext context = SpringApplication.run(PizzaApp.class, args);
//        PizzaDeliveryService fianonaPizzaDeliveryService = context.getBean("fianona", PizzaDeliveryService.class);
//        System.out.println(fianonaPizzaDeliveryService.orderPizza(new Margherita()));
//        PizzaDeliveryService capucinerPizzaDeliveryService = context.getBean("capuciner", PizzaDeliveryService.class);
//        System.out.println(capucinerPizzaDeliveryService.orderPizza(new Marinara()));
//        PizzeriaService pizzeriaChello = context.getBean(PizzeriaService.class);
//        System.out.println(pizzeriaChello.getName());
//        PizzeriaService pizzeriaLira = context.getBean("pizzeriaLira", PizzeriaService.class);
//        System.out.println(pizzeriaLira.getName());
    }

}

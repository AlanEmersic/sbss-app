package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Marinara;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzaConfig.class);
        PizzaDeliveryService fianonaPizzaDeliveryService = context.getBean("fianona", PizzaDeliveryService.class);
        System.out.println(fianonaPizzaDeliveryService.orderPizza(new Margherita()));
        PizzaDeliveryService capucinerPizzaDeliveryService = context.getBean("capuciner", PizzaDeliveryService.class);
        System.out.println(capucinerPizzaDeliveryService.orderPizza(new Marinara()));

        context.close();

        SpringApplication.run(PizzaApp.class, args);
    }

}

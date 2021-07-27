package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.model.Marinara;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        PizzaDeliveryService fianonaPizzaDeliveryService = context.getBean("fianona", PizzaDeliveryService.class);
        System.out.println(fianonaPizzaDeliveryService.orderPizza(new Margherita()));
        PizzaDeliveryService capucinerPizzaDeliveryService = context.getBean("capuciner", PizzaDeliveryService.class);
        System.out.println(capucinerPizzaDeliveryService.orderPizza(new Marinara()));

    }

}

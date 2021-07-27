package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.Pizzeria;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Pizza margherita = context.getBean("margherita", Pizza.class);
        Pizza marinara = context.getBean("marinara", Pizza.class);
        System.out.println(margherita.getIngredients());
        System.out.println(marinara.getIngredients());

        PizzaDeliveryService pizzaDeliveryService = context.getBean("pizzaDelivery", PizzaDeliveryService.class);
        System.out.println(pizzaDeliveryService.orderPizza(margherita));
        PizzaDeliveryService pizzaDeliveryService2 = context.getBean("pizzaDelivery2", PizzaDeliveryService.class);
        System.out.println(pizzaDeliveryService2.orderPizza(marinara));

        PizzeriaService pizzeriaService = context.getBean("pizzeria", PizzeriaService.class);
        System.out.println(pizzeriaService.getName());
        System.out.println(pizzeriaService.getAddress());

        PizzeriaService pizzeriaService2 = context.getBean("pizzeria2", PizzeriaService.class);
        System.out.println(pizzeriaService2.getName());
        System.out.println(pizzeriaService2.getAddress());
    }

}

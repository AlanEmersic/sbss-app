package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.error.RestControllerNotFoundException;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.CustomerService;
import com.agency04.sbss.pizza.service.PizzaService;
import com.agency04.sbss.pizza.service.impl.CapucinerPizzaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/capuciner")
public class CapucinerController {

    private final CustomerService customerService;
    private final CapucinerPizzaServiceImpl capucinerPizzaService;
    private List<DeliveryOrderForm> orders;

    public CapucinerController(CustomerService customerService, CapucinerPizzaServiceImpl capucinerPizzaService) {
        this.customerService = customerService;
        this.capucinerPizzaService = capucinerPizzaService;
        orders = new ArrayList<>();
    }

    @GetMapping("/list")
    public List<DeliveryOrderForm> getList() {
        return orders;
    }

    @PostMapping("/order")
    public void addOrder(@RequestBody final DeliveryOrderForm order) {
        if (Objects.nonNull(order.getCustomer()) && Objects.nonNull(order.getPizza())) {
            Customer findCustomer = customerService.get(order.getCustomer().getUsername());
            Pizza findPizza = capucinerPizzaService.get(order.getPizza().getName());
            if (Objects.nonNull(findCustomer) && Objects.nonNull(findPizza)) {
                orders.add(order);
            } else {
                throw new RestControllerNotFoundException("post order find error");
            }
        } else {
            throw new RestControllerNotFoundException("post order error");
        }
    }
}

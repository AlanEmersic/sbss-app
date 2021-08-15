package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.entity.Delivery;
import com.agency04.sbss.pizza.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<Delivery> getAll() {
        return deliveryService.getAll();
    }

    @GetMapping("/{id}")
    public Delivery get(@PathVariable Long id) {
        return deliveryService.get(id);
    }

    @PostMapping
    public void create(@RequestBody Delivery delivery) {
        deliveryService.save(delivery);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deliveryService.delete(id);
    }
}

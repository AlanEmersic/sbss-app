package com.agency04.sbss.pizza.controller;

import com.agency04.sbss.pizza.dto.DeliveryDto;
import com.agency04.sbss.pizza.form.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/list")
    public List<DeliveryDto> getAll() {
        return deliveryService.getAll();
    }

    @PostMapping("/order")
    public void create(@Valid @RequestBody final DeliveryOrderForm deliveryOrderForm) {
        deliveryService.save(deliveryOrderForm);
    }
}

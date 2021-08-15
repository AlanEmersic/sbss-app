package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    void save(Delivery delivery);

    Delivery get(Long id);

    List<Delivery> getAll();

    void delete(Long id);
}

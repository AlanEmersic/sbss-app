package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.entity.Delivery;
import com.agency04.sbss.pizza.error.NotFoundException;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import com.agency04.sbss.pizza.service.DeliveryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public void save(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    @Override
    public Delivery get(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("get error, delivery not found"));
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        deliveryRepository.delete(deliveryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("delete error, delivery not found")));
    }
}

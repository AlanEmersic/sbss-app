package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.dto.DeliveryDto;
import com.agency04.sbss.pizza.form.DeliveryOrderForm;

import java.util.List;

public interface DeliveryService {
    void save(DeliveryOrderForm deliveryOrderForm);

    List<DeliveryDto> getAll();
}

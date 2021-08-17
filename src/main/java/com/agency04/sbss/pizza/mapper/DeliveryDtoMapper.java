package com.agency04.sbss.pizza.mapper;

import com.agency04.sbss.pizza.dto.DeliveryDto;
import com.agency04.sbss.pizza.entity.Delivery;

public interface DeliveryDtoMapper {
    DeliveryDto map(Delivery delivery);
}

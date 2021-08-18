package com.agency04.sbss.pizza.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DeliveryDto {
    private Date submissionDate;
    private CustomerDto customer;
    private List<PizzaOrderDto> orders;
}

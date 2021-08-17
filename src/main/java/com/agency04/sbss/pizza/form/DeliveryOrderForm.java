package com.agency04.sbss.pizza.form;

import com.agency04.sbss.pizza.dto.CustomerDto;
import com.agency04.sbss.pizza.dto.PizzaOrderDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class DeliveryOrderForm {

    @NotNull
    private Date submissionDate;

    @NotNull
    private CustomerDto customer;

    @NotNull
    private PizzaOrderDto order;
}

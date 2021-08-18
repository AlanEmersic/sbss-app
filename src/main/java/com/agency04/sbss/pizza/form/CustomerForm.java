package com.agency04.sbss.pizza.form;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
public class CustomerForm {

    @NotEmpty
    private String username;

    @Valid
    private CustomerDetailsForm details;
}

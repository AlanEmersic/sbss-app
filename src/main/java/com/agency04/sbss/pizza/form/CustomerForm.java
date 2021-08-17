package com.agency04.sbss.pizza.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CustomerForm {

    @NotEmpty
    private String username;

    @NotNull
    private CustomerDetailsForm details;
}

package com.agency04.sbss.pizza.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CustomerDetailsForm {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String phone;
}

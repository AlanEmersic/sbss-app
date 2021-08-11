package com.agency04.sbss.pizza.model;

public class DeliveryOrderForm {
    private Customer customer;
    private Pizza pizza;

    public DeliveryOrderForm(Customer customer, Pizza pizza) {
        this.customer = customer;
        this.pizza = pizza;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}

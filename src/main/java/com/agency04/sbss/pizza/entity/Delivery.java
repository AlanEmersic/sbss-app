package com.agency04.sbss.pizza.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date submissionDate;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customerId", updatable = false)
    @JsonIgnore
    private Customer customer;

    @OneToMany(targetEntity = PizzaOrder.class, mappedBy = "delivery",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PizzaOrder> pizzaOrders = new ArrayList<>();
}

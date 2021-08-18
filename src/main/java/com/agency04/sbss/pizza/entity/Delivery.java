package com.agency04.sbss.pizza.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
            fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PizzaOrder> pizzaOrders = new ArrayList<>();
}

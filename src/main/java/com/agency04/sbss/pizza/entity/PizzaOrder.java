package com.agency04.sbss.pizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quantity;

    @Enumerated(EnumType.STRING)
    private PizzaSize size;

    @ManyToOne(targetEntity = Pizza.class)
    @JoinColumn(name = "pizzaId", updatable = false)
    @JsonIgnore
    private Pizza pizza;

    @ManyToOne(targetEntity = Delivery.class)
    @JoinColumn(name = "deliveryId", updatable = false)
    @JsonIgnore
    private Delivery delivery;
}

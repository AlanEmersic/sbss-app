package com.agency04.sbss.pizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @JoinTable(name = "ingredients", joinColumns = @JoinColumn(name = "ingredients"))
//    @Column(name = "ingredient")
//    @Enumerated(EnumType.STRING)
//    private List<Ingredient> ingredients;
    @Enumerated(EnumType.STRING)
    private Ingredient ingredients;

    @OneToMany(targetEntity = PizzaOrder.class, mappedBy = "pizza",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PizzaOrder> pizzaOrders = new ArrayList<>();

}

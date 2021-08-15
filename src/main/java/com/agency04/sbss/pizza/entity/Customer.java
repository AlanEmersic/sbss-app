package com.agency04.sbss.pizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerDetailsId", referencedColumnName = "id")
    @JsonIgnore
    private CustomerDetails customerDetails;

    @OneToMany(targetEntity = Delivery.class, mappedBy = "customer",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Delivery> deliveries = new ArrayList<>();
}

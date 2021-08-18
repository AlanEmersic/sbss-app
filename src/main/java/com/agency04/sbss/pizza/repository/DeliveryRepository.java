package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findByCustomer_Username(String username);
}

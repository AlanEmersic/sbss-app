package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
    Optional<CustomerDetails> findTopByCustomer_Username(String username);
}

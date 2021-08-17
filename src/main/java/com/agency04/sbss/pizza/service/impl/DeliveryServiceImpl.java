package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.dto.DeliveryDto;
import com.agency04.sbss.pizza.entity.Customer;
import com.agency04.sbss.pizza.entity.Delivery;
import com.agency04.sbss.pizza.entity.PizzaOrder;
import com.agency04.sbss.pizza.error.NotFoundException;
import com.agency04.sbss.pizza.form.DeliveryOrderForm;
import com.agency04.sbss.pizza.mapper.DeliveryDtoMapper;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import com.agency04.sbss.pizza.repository.PizzaOrderRepository;
import com.agency04.sbss.pizza.service.DeliveryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryDtoMapper deliveryDtoMapper;
    private final CustomerRepository customerRepository;
    private final PizzaOrderRepository pizzaOrderRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryDtoMapper deliveryDtoMapper,
                               CustomerRepository customerRepository, PizzaOrderRepository pizzaOrderRepository) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryDtoMapper = deliveryDtoMapper;
        this.customerRepository = customerRepository;
        this.pizzaOrderRepository = pizzaOrderRepository;
    }


    @Override
    public void save(DeliveryOrderForm deliveryOrderForm) {
        Optional<Customer> optionalCustomer = customerRepository.
                findTopByUsername(deliveryOrderForm.getCustomer().getUsername());

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            PizzaOrder pizzaOrder = new PizzaOrder();
            BeanUtils.copyProperties(deliveryOrderForm.getOrder(), pizzaOrder);
            pizzaOrderRepository.save(pizzaOrder);
            Optional<Delivery> optionalDelivery = deliveryRepository.findByCustomer_Username(customer.getUsername());

            Delivery delivery;
            if (optionalDelivery.isPresent()) {
                delivery = optionalDelivery.get();
            } else {
                delivery = new Delivery();
                delivery.setCustomer(customer);
                delivery.setSubmissionDate(deliveryOrderForm.getSubmissionDate());
            }
            delivery.getPizzaOrders().add(pizzaOrder);
            deliveryRepository.save(delivery);
        }
        else {
            throw new NotFoundException("post deliveryOrderForm error, customer not found");
        }
    }

    @Override
    public List<DeliveryDto> getAll() {
        return deliveryRepository.findAll().stream().map(deliveryDtoMapper::map).collect(Collectors.toList());
    }
}

package com.dbproject.controllers;

import com.dbproject.model.Order;
import com.dbproject.model.PaymentType;
import com.dbproject.model.User;
import com.dbproject.model.Vehicle;
import com.dbproject.repositories.OrderRepository;
import com.dbproject.repositories.PaymentTypeRepository;
import com.dbproject.repositories.UsersRepository;
import com.dbproject.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")

public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    VehiclesRepository vehiclesRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PaymentTypeRepository paymentTypeRepository;

    @GetMapping("/orders/showAll")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orders = new ArrayList<Order>();
            orders.addAll(orderRepository.findAll());

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/orders/show")
    public ResponseEntity<Order> getOrderByID(@Param("orderID") String orderID) {
        try {
            Order orders = orderRepository.findById(orderID).get();
            return new ResponseEntity<>(orders, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order,
                                             @Param("buyerID") String buyerID,
                                             @Param("selleID") String sellerID,
                                             @Param("paymentID") String paymentID,
                                             @Param("vehicleID") String vehicleID) {
        try {

            //fill the missing fields with embedded objects
            User tempUser = usersRepository.findById(buyerID).get();
            order.setBuyer_id(tempUser);
            tempUser = usersRepository.findById(sellerID).get();
            order.setSeller_id(tempUser);
            Vehicle vehicle = vehiclesRepository.findById(vehicleID).get();
            order.setValue(vehicle.getValue());
            order.setVehicle(vehicle);
            PaymentType paymentType = paymentTypeRepository.findById(paymentID).get();
            order.setPaymentType(paymentType);

            Order orderSaved = orderRepository.save(order);
            return new ResponseEntity<>(orderSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}



package com.dbproject.controllers;

import com.dbproject.model.Order;
import com.dbproject.model.User;
import com.dbproject.model.Vehicle;
import com.dbproject.repositories.OrderRepository;
import com.dbproject.repositories.UsersRepository;
import com.dbproject.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orders = new ArrayList<Order>();
            orders.addAll(orderRepository.findAll());

            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order orderSaved = orderRepository.save(order);
            return new ResponseEntity<>(orderSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}



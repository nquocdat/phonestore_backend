package com.example.phonestore_backend.rest;

import com.example.phonestore_backend.dao.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private OrderItemRepository orderItemRepository;

    @Autowired
    public TestController(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    @GetMapping("/")
    public void test() {
        orderItemRepository.saveAndFlush()
    }
}

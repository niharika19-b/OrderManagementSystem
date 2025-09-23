package com.cascade.order.controller;
import java.util.List;

import com.cascade.order.entity.Order;
import com.cascade.order.repository.OrderRepository;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/orders")
public class OrderController {
	   private final OrderRepository orderRepository;

		public OrderController(OrderRepository orderRepository) {
			this.orderRepository = orderRepository;
		}

		@PostMapping
		public Order createOrder(@RequestBody Order order) {
			return orderRepository.save(order);
		}
	   @GetMapping("/{id}")
		public Order getOrder(@PathVariable Long id) {
			return orderRepository.findById(id).orElse(null);
		}
	  
       @DeleteMapping("/{id}")
       public String deleteOrder(@PathVariable Long id) {
           orderRepository.deleteById(id);
           return "Order deleted successfully";
         
       }}




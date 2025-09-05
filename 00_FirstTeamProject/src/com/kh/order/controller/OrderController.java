package com.kh.order.controller;

import java.util.List;

import com.kh.order.model.service.OrderService;
import com.kh.order.model.vo.Order;

public class OrderController {
	
	public List<Order> findAll() {
		
		List<Order> orders = new OrderService().findAll();
		
		return orders;
	}

}

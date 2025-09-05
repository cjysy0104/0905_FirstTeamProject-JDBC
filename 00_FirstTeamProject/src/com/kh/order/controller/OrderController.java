package com.kh.order.controller;

import java.util.List;

import com.kh.order.model.service.OrderService;
import com.kh.order.model.vo.Order;

public class OrderController {
	
	public List<Order> findAll() {
		List<Order> orders = new OrderService().findAll();
		return orders;
	}
	
	public Order findById(String order_Id) {
		Order order = new OrderService().findById(order_Id);
		return order;
	}
	

	
	public int save(String order_Id, String user_Id, String product_Id, int order_No) {
		Order order = new Order(order_Id, user_Id, product_Id, order_No);
		int result = new OrderService().save(order);
		return result;
	}
	
	

}

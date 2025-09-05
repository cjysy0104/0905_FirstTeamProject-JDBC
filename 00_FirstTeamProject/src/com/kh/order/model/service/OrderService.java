package com.kh.order.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.function.Function;

import com.kh.order.model.dao.OrderDao;
import com.kh.order.model.vo.Order;

public class OrderService {
	
	private Connection conn = null;
	
	public OrderService() {
		this.conn = getConnection();
	}
	
	private <T> T executeQuery(Function<Connection, T> daoFunction) {
		Connection conn = null;
		T result = null;
		conn = getConnection();
		result = daoFunction.apply(conn);
		close(conn);
		return result;
	}
	
	public List<Order> findAll(){
		return executeQuery(new OrderDao()::findAll);
	}
	
	public int save(Order order) {
		Connection conn = getConnection();
		int result = new OrderDao().save(conn, order);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}

}

package com.kh.order.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.order.model.vo.Order;

public class OrderDao {
	
	private Properties prop = new Properties();
	
	public OrderDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/order-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Order> findAll(Connection conn){
		
		List<Order> orders = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Order order = new Order(rset.getString("ORDER_ID")
									   ,rset.getString("USER_ID")
									   ,rset.getString("PRODUCT_ID")
									   ,rset.getInt("ORDER_NO")
									   ,rset.getDate("ORDER_DATE"));
				orders.add(order);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return orders;
	}
	
	
	
	public int save(Connection conn, Order order) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			prop.loadFromXML(new FileInputStream("resources/order-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String sql = prop.getProperty("save");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, order.getOrder_Id());
			pstmt.setString(2, order.getUser_Id());
			pstmt.setString(3, order.getProduct_Id());
			pstmt.setInt(4, order.getOrder_No());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	

}

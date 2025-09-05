package com.kh.order.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Order {
	
	private String order_Id;   //ORDER_ID VARCHAR2(15) NOT NULL,
	private String user_Id;    //USER_ID VARCHAR2(20) UNIQUE NOT NULL,
	private String product_Id; //PRODUCT_ID VARCHAR2(15) NOT NULL,
	private int order_No;      //ORDER_NO NUMBER NOT NULL,
	private Date order_Date;   //ORDER_DATE DATE NOT NULL
	
	public Order() {
		super();
	}

	public Order(String order_Id, String user_Id, String product_Id, int order_No, Date order_Date) {
		super();
		this.order_Id = order_Id;
		this.user_Id = user_Id;
		this.product_Id = product_Id;
		this.order_No = order_No;
		this.order_Date = order_Date;
	}
	
	
	public Order(String order_Id, String user_Id, String product_Id, int order_No) {
		super();
		this.order_Id = order_Id;
		this.user_Id = user_Id;
		this.product_Id = product_Id;
		this.order_No = order_No;
	}

	public String getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	public String getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}

	public int getOrder_No() {
		return order_No;
	}

	public void setOrder_No(int order_No) {
		this.order_No = order_No;
	}

	public Date getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order_Date, order_Id, order_No, product_Id, user_Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(order_Date, other.order_Date) && Objects.equals(order_Id, other.order_Id)
				&& order_No == other.order_No && Objects.equals(product_Id, other.product_Id)
				&& Objects.equals(user_Id, other.user_Id);
	}
	
	

}

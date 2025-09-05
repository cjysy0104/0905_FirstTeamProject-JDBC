package com.kh.product.model.vo;

import java.util.Objects;

public class Product {
	
	private String prdId;
	private String prdName;
	private String category;
	private int price;
	private int stock;
	public Product() {
		super();
	}
	public Product(String prdId, String prdName, String category, int price, int stock) {
		super();
		this.prdId = prdId;
		this.prdName = prdName;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}
	public String getPrdId() {
		return prdId;
	}
	public String getPrdName() {
		return prdName;
	}
	public String getCategory() {
		return category;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, prdId, prdName, price, stock);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(prdId, other.prdId)
				&& Objects.equals(prdName, other.prdName) && price == other.price && stock == other.stock;
	}
	@Override
	public String toString() {
		return "[상품번호: " + prdId + ", 상품명: " + prdName + ", 카테고리: " + category + ", 가격: " + price
				+ ", 재고수량: " + stock + "]";
	}
	
	
}

package com.kh.product.model.dto;

import java.util.Objects;

public class ProductDto {

	private String prdId;
	private String prdName;
	private String category;
	private int price;
	private int stock;
	public ProductDto() {
		super();
	}
	public ProductDto(String prdName, String category, int price, int stock) {
		super();
		this.prdName = prdName;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}
	public String getPrdId() {
		return prdId;
	}
	public void setPrdId(String prdId) {
		this.prdId = prdId;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
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
		ProductDto other = (ProductDto) obj;
		return Objects.equals(category, other.category) && Objects.equals(prdId, other.prdId)
				&& Objects.equals(prdName, other.prdName) && price == other.price && stock == other.stock;
	}
	
	
	
}

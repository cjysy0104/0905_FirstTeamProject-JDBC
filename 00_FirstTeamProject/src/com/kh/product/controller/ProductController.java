package com.kh.product.controller;

import java.util.List;

import com.kh.product.model.dto.ProductDto;
import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Product;

public class ProductController {

	/**
	 * Controller클래스: View에서 입력받은 값들을 product의 필드로 대입하여 객체 생성 후 product 객체를 매개변수로
	 * 메서드를 호출하여 result값을 받고 반환합니다.
	 * 
	 * @param 상품번호(String)
	 * @param 상품명(String)
	 * @param 카테고리(String)
	 * @param 가격(int)
	 * @param 재고수량(int)
	 * @return (int): Success -> 1, Fail -> 0
	 */
	public int save(String prdId, String prdName, String category, int price, int stock) {
		Product product = new Product(prdId, prdName, category, price, stock);
		int result = new ProductService().save(product);
		return result;
	}

	/**
	 * Controller클래스: View에서 호출되어 메서드를 호출하고 List형태로 담긴 값(products)을 받아 반환합니다.
	 * 
	 * @return List<Product>
	 */
	public List<Product> findAll() {
		List<Product> products = new ProductService().findAll();
		return products;
	}

	/**
	 * Controller클래스: View에서 입력받은 값을 매개변수로 메서드를 호출합니다. List 형태로 반환받습니다.
	 * 
	 * @param prdName (상품명)
	 * @return (List)Products
	 */
	public List<Product> findByName(String prdName) {
		List<Product> products = new ProductService().findByName(prdName);
		return products;
	}

	public Product findById(String prdId) {
		Product product = new ProductService().findById(prdId);
		return product;
	}

	public int update(String prdId, String prdName, String category, int price, int stock) {
		ProductDto prdDto = new ProductDto(prdName, category, price, stock);
		int result = new ProductService().update(prdId, prdDto);
		return result;
	}

}

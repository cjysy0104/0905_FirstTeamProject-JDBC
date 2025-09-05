package com.kh.product.controller;

import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Product;

public class ProductController {

	/**
	 * Controller클래스: View에서 입력받은 값들을 product의 필드로 대입하여 객체 생성 후 
	 *  product 객체를 매개변수로 메서드를 호출하여 result값을 받고 반환합니다.
	 * @param prdId
	 * @param prdName
	 * @param category
	 * @param price
	 * @param stock
	 * @return
	 */
	public int save(String prdId, String prdName, String category, int price, int stock) {
		
		Product product = new Product(prdId, prdName, category, price, stock);
		int result = new ProductService().save(product);

		return result;
	}

}

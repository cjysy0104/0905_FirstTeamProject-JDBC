package com.kh.product.model.service;

import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;

import java.sql.Connection;
import java.util.List;

import com.kh.product.model.dao.ProductDao;
import com.kh.product.model.dto.ProductDto;
import com.kh.product.model.vo.Product;

public class ProductService {

	private Connection conn = null;

	public ProductService() {
		this.conn = getConnection();
	}

	public int save(Product product) {
		if (product == null) {
			close(conn);
			return 0;
		}

		int result = new ProductDao().save(conn, product);

		if (result > 0) {
			commit(conn);
		}

		close(conn);

		return result;
	}

	public List<Product> findAll() {
		List<Product> products = new ProductDao().findAll(conn);

		close(conn);

		return products;
	}

	public List<Product> findByName(String prdName) {
		List<Product> products = new ProductDao().findByName(conn, prdName);

		close(conn);

		return products;
	}

	public Product findById(String prdId) {
		Product product = new ProductDao().findById(conn, prdId);
		
		close(conn);
		
		return product;
	}

	public int update(String prdId, ProductDto prdDto) {
		
		Product idCheck = new ProductDao().findById(conn, prdId);
		if(idCheck == null) {
			return 0;
		}
		int result = new ProductDao().update(conn, prdId, prdDto);
		
		close(conn);
		
		return result;
	}

}

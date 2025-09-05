package com.kh.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.product.model.dto.ProductDto;
import com.kh.product.model.vo.Product;

public class ProductDao {

	private Properties prop = new Properties();

	public ProductDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/product-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int save(Connection conn, Product product) {
		PreparedStatement pstat = null;
		int result = 0;

		String sql = prop.getProperty("save");

		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, product.getPrdId());
			pstat.setString(2, product.getPrdName());
			pstat.setString(3, product.getCategory());
			pstat.setInt(4, product.getPrice());
			pstat.setInt(5, product.getStock());
			result = pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Product> findAll(Connection conn) {
		PreparedStatement pstat = null;
		ResultSet rset = null;
		List<Product> products = new ArrayList();

		String sql = prop.getProperty("findAll");

		try {
			pstat = conn.prepareStatement(sql);
			rset = pstat.executeQuery();

			while (rset.next()) {
				Product product = new Product(rset.getString("PRD_ID")
											, rset.getString("PRD_NAME")
											, rset.getString("CATEGORY")
											, rset.getInt("PRICE")
											, rset.getInt("STOCK"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	public List<Product> findByName(Connection conn, String prdName) {
		PreparedStatement pstat = null;
		ResultSet rset = null;
		Product product = null;
		List<Product> products = new ArrayList();

		String sql = prop.getProperty("findByName");

		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, "%" + prdName + "%");
			rset = pstat.executeQuery();

			while (rset.next()) {
				product = new Product(rset.getString("PRD_ID")
											, rset.getString("PRD_NAME")
											, rset.getString("CATEGORY")
											, rset.getInt("PRICE")
											, rset.getInt("STOCK"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	public Product findById(Connection conn, String prdId) {
		PreparedStatement pstat = null;
		ResultSet rset = null;
		Product product = null;
		
		String sql = prop.getProperty("findById");
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, prdId);
			rset = pstat.executeQuery();
			
			if(rset.next()) {
				product = new Product(rset.getString("PRD_ID")
						, rset.getString("PRD_NAME")
						, rset.getString("CATEGORY")
						, rset.getInt("PRICE")
						, rset.getInt("STOCK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return product;
	}

	public int update(Connection conn, String prdId, ProductDto prdDto) {
		PreparedStatement pstat = null;
		int result = 0;
		
		String sql = prop.getProperty("update");
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, prdDto.getPrdName());
			pstat.setString(2, prdDto.getCategory());
			pstat.setInt(3, prdDto.getPrice());
			pstat.setInt(4, prdDto.getStock());
			pstat.setString(5, prdId);
			result = pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}

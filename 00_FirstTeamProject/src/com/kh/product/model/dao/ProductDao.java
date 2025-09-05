package com.kh.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

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

}

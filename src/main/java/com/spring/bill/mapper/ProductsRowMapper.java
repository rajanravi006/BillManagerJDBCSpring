package com.spring.bill.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.bill.entity.*;

public class ProductsRowMapper  implements RowMapper<Products>{

	@Override
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products products = new Products();
		products.setId(rs.getString("id"));
		products.setName(rs.getString("name"));
		products.setPrice(rs.getDouble("price"));
		return products; 
		
	}

	
}

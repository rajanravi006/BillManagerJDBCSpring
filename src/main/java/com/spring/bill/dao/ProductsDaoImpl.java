package com.spring.bill.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.bill.entity.Products;
import com.spring.bill.mapper.ProductsRowMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("productsDao")
public class ProductsDaoImpl implements ProductsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Products getData(String productId) {
		String query = "select * from products where id=?";
		RowMapper<Products> rowMapper = new ProductsRowMapper();
		try {
			Products products = this.jdbcTemplate.queryForObject(query, rowMapper, productId);
			return products;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
//		Products products = this.jdbcTemplate.queryForObject(query, rowMapper, productId);
//		return products;
	}
	
}

package com.spring.bill;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan(basePackages = {"com.spring.bill.dao"})
public class JdbcConfig {
	
	@Bean("ds")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/shop");
		ds.setUsername("root");
		ds.setPassword("9798878724");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
//	@Bean("productsDao")
//	public ProductsDao getProductsDao() {
//		ProductsDaoImpl productsDao = new ProductsDaoImpl();
//		productsDao.setJdbcTemplate(getTemplate());
//		return productsDao;
//	}
//	
//	@Bean("historyDao")
//	public HistoryDao getHistoryDao() {
//		HistoryDaoImpl historyDao = new HistoryDaoImpl();
//		historyDao.setJdbcTemplate(getTemplate());
//		return historyDao;
//	}
}

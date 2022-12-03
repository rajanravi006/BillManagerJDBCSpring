package com.spring.bill.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.bill.entity.History;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("historyDao")
public class HistoryDaoImpl implements HistoryDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public Integer insertHistory(History history) {
		String query = "insert into history(order_id, amount) values(?,?)";
		Integer response = this.jdbcTemplate.update(query, history.getOrderId(), history.getAmount());
		return response;
	}

}

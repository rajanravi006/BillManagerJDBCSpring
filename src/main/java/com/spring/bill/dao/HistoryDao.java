package com.spring.bill.dao;

import org.springframework.stereotype.Component;

import com.spring.bill.entity.History;

@Component
public interface HistoryDao {
	
	public Integer insertHistory(History history);
}

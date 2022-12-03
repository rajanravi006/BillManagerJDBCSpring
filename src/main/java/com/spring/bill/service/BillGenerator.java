package com.spring.bill.service;

import java.util.List;

import com.spring.bill.entity.Receipt;

public interface BillGenerator {
	
	public String getBill(List<String> productList, String customerId);
	public Receipt getReceiptObject(List<String> productList, double totalAmount, String customerId);
	public String getReceiptJSON(Receipt receipt);
	public void insertBill(double amount, String customerId);
}

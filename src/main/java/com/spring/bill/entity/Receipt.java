package com.spring.bill.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
	
	private List<String> productNames;
	private double totalAmount;
	private String orderId;
}

package com.spring.bill.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.gson.Gson;
import com.spring.bill.JdbcConfig;
import com.spring.bill.dao.HistoryDao;
import com.spring.bill.dao.ProductsDao;
import com.spring.bill.entity.History;
import com.spring.bill.entity.Receipt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillGeneratorImpl implements BillGenerator {
	
	private double totalAmount;
	
	private ProductsDao productsDao;
	
	private Receipt receipt;
	
	private HistoryDao historyDao;
	
	
	
	@Override
	public String getBill(List<String> productList, String customerId) {
		double amount = 0;
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		this.productsDao = context.getBean("productsDao", ProductsDao.class);
		List<String> itemsToAdd = new ArrayList<>();
		 for(String product:productList) {
        	 amount+=productsDao.getData(product).getPrice();
        	 itemsToAdd.add(productsDao.getData(product).getName());
		 }
		 this.totalAmount=amount;
		 this.receipt = getReceiptObject(itemsToAdd, amount, customerId);
		 insertBill(amount, customerId);
		 return getReceiptJSON(receipt);
		 
	}	


	@Override
	public Receipt getReceiptObject(List<String> productList, double totalAmount, String customerId) {
		Receipt rec = new Receipt();
		rec.setProductNames(productList);
        rec.setOrderId(customerId);
        rec.setTotalAmount(totalAmount);
        return rec;  
	}


	@Override
	public String getReceiptJSON(Receipt receipt) {
		return (new Gson().toJson(receipt));
	}
	
	@Override
	public void insertBill(double amount, String customerId) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		this.historyDao = context.getBean("historyDao", HistoryDao.class);
		History history = new History();
		history.setAmount(amount);
		history.setOrderId(customerId);
		Integer response = historyDao.insertHistory(history);
		System.out.println(response);
		
	}
	

}

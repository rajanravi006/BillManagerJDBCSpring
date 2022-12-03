package com.spring.bill;

import java.util.ArrayList;
import java.util.Scanner;

import com.spring.bill.service.BillGenerator;
import com.spring.bill.service.BillGeneratorImpl;




public class App 
{	
	
    public static void main( String[] args )
    {
        System.out.println( "----------Bill Generation System---------" );
        
        ArrayList<String> inputList=new ArrayList<>();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter number of items: ");
        Integer n=input.nextInt();
        System.out.println("Enter the input: ");
        while(n!=0) {
        	String a=input.next();
        	inputList.add(a);
        	n--;
        }
        
         System.out.println(inputList);
         
         Scanner sc= new Scanner(System.in);
         System.out.println("Enter the Customer ID");
         String customerId = sc.nextLine();
         
         BillGenerator billGenerator = new BillGeneratorImpl();
         System.out.println(billGenerator.getBill(inputList, customerId));
         
         input.close(); sc.close();
    }
}

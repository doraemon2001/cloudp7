package com.example.program7;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Program7Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac=SpringApplication.run(Program7Application.class, args);
		CustomerService cr=ac.getBean(CustomerService.class);
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter the choice");
			System.out.println("1.Enter details\n2.Update details\n3.get details\n4.delete\n5.exit");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:System.out.println("Enter customer fname");
					String fname=sc.next();
					System.out.println("Enter customer lname");
					String lname=sc.next();
					cr.addCustomer(fname, lname);
					break;
			case 2:System.out.println("Enter customer id to update");
					Long id=sc.nextLong();
					System.out.println("Enter customer fname");
					String fname1=sc.next();
					System.out.println("Enter customer lname");
					String lname1=sc.next();
					cr.updateCustomer(id,fname1,lname1);
					break;
			case 3:System.out.println("The details are as below");
					cr.findAllCustomers().forEach(System.out::println);
					break;
			case 4:System.out.println("Enter the id to delete");
					Long id1=sc.nextLong();
					cr.deleteCustomer(id1);
					System.out.println("Customer deleted successfully");
					break;
			
			case 5:System.exit(0);
			}
			
		}
	
	}

}

package com.example.program7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo cr;
	
	public List<Customer> findAllCustomers()
	{
		return cr.findAll();
	}
	
	public void addCustomer(String fname,String Lname)
	{
		Customer cust=new Customer();
		cust.setFname(fname);
		cust.setLname(Lname);
		cr.save(cust);
	}
	public void deleteCustomer(Long id)
	{
		cr.deleteById(id);
	}
	public void updateCustomer(Long id,String fname,String lname)
	{
		Customer cust=cr.findById(id).orElse(null);
		if(cust!=null)
		{
			cust.setFname(fname);
			cust.setLname(lname);
			cr.save(cust);
		}
	}
}

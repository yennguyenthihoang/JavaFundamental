
package fr.epita.bank.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.bank.datamodel.Customer;

public class CustomerFileDAO{
	
	private PrintWriter writer;
	private Scanner scanner;
	private File file;
	
	public CustomerFileDAO(String path) throws IOException {
		//only one construction so it's not good, not check file is exist -> resolve
		//this.writer = new PrintWriter(new FileOutputStream(new File(path), true));
		File file = new File(path);
		if(!file.exists()) {
			//create folder with parents
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		this.file = file;
		this.writer = new PrintWriter(new FileOutputStream(new File(path), true));
		this.scanner = new Scanner(file);
	}
	public void create(Customer customer) {
		writer.println("-------");
		writer.println(customer.getName());
		writer.println(customer.getAddress());
		writer.println("-------");
		writer.flush();
	}
	public void update(Customer customer) {
		//Create a copy file and replace the needed values then replace the root file
		
		//the same file: found the customer in the list and set new values for this customer
		while(scanner.hasNext()) {
			scanner.nextLine();
			String name = scanner.nextLine();
			String address = scanner.nextLine();
			if(name.startsWith(customer.getName()) || address.startsWith(customer.getAddress())) {
				name = "Yen";
				address = "";
			}
			scanner.nextLine();
		}
		try {
			scanner = new Scanner(this.file);
			
		}catch(Exception e) {
			
		}		
	}
	public void delete(Customer customer) {
		
	}
	public List<Customer> search(Customer criteria) {
		List<Customer> customers = new ArrayList<Customer>(); 
		while(scanner.hasNext()) {
			scanner.nextLine();
			String name = scanner.nextLine();
			String address = scanner.nextLine();
			if(name.startsWith(criteria.getName()) || address.startsWith(criteria.getAddress())) {
				Customer customer = new Customer(name, address);
				customers.add(customer);
			}
			scanner.nextLine();
		}
		try {
			scanner = new Scanner(this.file);
			
		}catch(Exception e) {
			
		}
		return customers;
	}
	public Customer getById(String name) {
		return null;
	}
	//take all code about file operations to reformat
}
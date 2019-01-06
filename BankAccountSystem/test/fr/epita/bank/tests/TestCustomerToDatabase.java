package fr.epita.bank.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.service.CustomerJDBCDAO;

public class TestCustomerToDatabase {

	public TestCustomerToDatabase() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws SQLException {
		
		Customer customer = new Customer("Nicolas", "Paris");
		CustomerJDBCDAO dao = new CustomerJDBCDAO();
		//Create new customer
		//dao.create(new Customer("Thomas", "Creteil"));
		
		//Search a customer
		//System.out.println(dao.search(customer));
		//System.out.println(dao.search(new Customer("Thomas", "Creteil")));
		
		//Update a customer
		//dao.update(new Customer("Thomas", "Toulouse"));
		//System.out.println(dao.search(new Customer("Thomas", "")));
		
		//Delete a customer
		System.out.println("Before deleting: ");
		testSearchCustomerFromDB();
		dao.delete(new Customer("Thomas", ""));
		System.out.println("After deleting: ");
		testSearchCustomerFromDB();
	}
	
	private static void testSearchCustomerFromDB() throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		System.out.println(connection.getSchema());
		String selectQuery = "select * from customer";
		String selectQueryAlt = "select name, address from customer";
		
		//PreparedStatment is preferred to prevent SQL injections
		PreparedStatement preparedStatement = connection.prepareCall(selectQueryAlt);
		ResultSet results = preparedStatement.executeQuery();
		
		while(results.next()) {
			String column1 = results.getString(1);
			String column2 = results.getString(2);
			System.out.println(column1 + " " + column2);
			//System.out.println(column2);
		}
		connection.close();
	}
	private static void testInsertCustomerToDB() throws SQLException {
		Connection insertConnection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		
		String insertQuery = "insert into CUSTOMER(name, address) values ('Clement', 'Montreuil')";
		PreparedStatement insertStatement = insertConnection.prepareStatement(insertQuery);
		insertStatement.execute();

		insertConnection.close();
		insertStatement.close();
	}
	//Next time: how to select, insert data from java to the table
}

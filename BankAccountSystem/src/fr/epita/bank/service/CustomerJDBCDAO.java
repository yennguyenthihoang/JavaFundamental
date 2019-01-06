package fr.epita.bank.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.bank.datamodel.Customer;

public class CustomerJDBCDAO {

	public void create(Customer customer) {
		//try catch block will automatically call close function
		//concat is not good
		String insertQuery = "insert into CUSTOMER(name, address) values ('" + customer.getName() + "', '" + customer.getAddress() + "')";
		String sqlCommand = "insert into CUSTOMER(name, address) values (?,?)";
		Configuration conf = Configuration.getInstance();
		
		String jdbcUrl = conf.getConfigurationValue("jdbc.url");
		String jdbcUser = conf.getConfigurationValue("jdbc.user");
		String jdbcPass = conf.getConfigurationValue("jdbc.password");
		try(Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass)){
			
			PreparedStatement insertStatement = connection.prepareStatement(sqlCommand);
			insertStatement.setString(1, customer.getName());
			insertStatement.setString(2, customer.getAddress());
			insertStatement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(Customer customer) {
		//UPDATE CUSTOMER SET ADDRESS='Toulouse' where NAME='Thomas'
		String sqlCommand = "update Customer set address = ? where name=?";
		
		try(Connection connection = getConnection()){
			PreparedStatement updateStatement = connection.prepareStatement(sqlCommand);
			updateStatement.setString(1, customer.getAddress());
			updateStatement.setString(2, customer.getName());
			updateStatement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(Customer customer) {
		//DELETE FROM CUSTOMER WHERE name='Thomas';
		String sqlCommand = "delete from Customer where name = ?";
		
		//Use try catch to automatically close the connection
		try(Connection connection = getConnection()){
			PreparedStatement deleteStatement = connection.prepareStatement(sqlCommand);
			deleteStatement.setString(1, customer.getName());
			deleteStatement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//why dont put string name and string address: not stable
	public List<Customer> search(Customer customer) throws SQLException {
		String selectQueryAlt = "select name, address from customer where name like ? or address = ?";
		List<Customer> customers = new ArrayList<Customer>();
		
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareCall(selectQueryAlt);
			preparedStatement.setString(1,  customer.getName()+ "%");
			preparedStatement.setString(2,  customer.getAddress());
			ResultSet results = preparedStatement.executeQuery();

			while(results.next()) {
				Customer currentCustomer = new Customer(results.getString("name"), results.getString("address"));
				customers.add(currentCustomer);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	
	public void findById() {
		
	}
	
	public Connection getConnection() throws SQLException {
		
		Configuration conf = Configuration.getInstance();
		String jdbcUrl = conf.getConfigurationValue("jdbc.url");
		String jdbcUser = conf.getConfigurationValue("jdbc.user");
		String jdbcPass = conf.getConfigurationValue("jdbc.password");
		Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
		
		return connection;
	}
	
}

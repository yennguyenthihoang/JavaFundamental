package fr.epita.bank.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private Properties properties;
	private static Configuration instance;
	
	private Configuration() {
		// create instances with static constructor
	}
	public static Configuration getInstance() {
		if(instance == null) {
			instance = new Configuration();
		}
		return instance;
	}
	public String getConfigurationValue(String configurationKey) {
		if(this.properties == null)
		properties = new Properties();
		//TODO: make the test.properties variable use a system variable?
		try(InputStream is = new FileInputStream(new File("app.properties"))){
			properties.load(is);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(configurationKey);
	}
	

}

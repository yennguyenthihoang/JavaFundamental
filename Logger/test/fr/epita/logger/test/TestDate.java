package fr.epita.logger.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public TestDate() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.print(date);
		//format date: yyyy-mm-dd to sort to analize your logs
		
		String format = "yyyy-MM-dd HH:mm:ss,SSS";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		System.out.println(dateFormat.format(date) + "\n");
	}

}

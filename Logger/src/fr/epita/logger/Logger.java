package fr.epita.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	private static PrintWriter writer; // static is link to last class to use automally
	private static boolean initialized = false;

	public static void logMessage(String message){
		//Call lazy intialization to constructor
		if(!initialized) {
			try {
				writer = new PrintWriter(new FileWriter(new File("application.log"), true));
			}catch(IOException e) { // Exception will throws all ex so it's not good, should specific
				System.out.println("error while initializing logging file");
				e.printStackTrace();
				writer = new PrintWriter(System.out);
			}
			
			initialized = true;
		}
		Date date = new Date();
		String format = "yyyy-MM-dd_HH:mm:ss, SSS";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		writer.println("Date" + dateFormat.format(date) + "\n" + message);	
		writer.flush();
	}

}


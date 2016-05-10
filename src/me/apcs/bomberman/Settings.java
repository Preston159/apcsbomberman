package me.apcs.bomberman;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
	
	public static Properties p = new Properties();
	private static String file = "./options.properties";
	private static File f;
	
	static {
		//add default settings here
		p.setProperty("defaultSpeed", "1");
	}
	
	public static void init() {
		f = new File(file);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			p.load(fis);
		} catch(IOException ioe) {
			
		}
		
	}
	
}

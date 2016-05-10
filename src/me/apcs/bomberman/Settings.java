/**
 * Settings.java
 * @author Preston Petrie
 */

package me.apcs.bomberman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
	
	public static Properties p = new Properties();
	public static boolean readSuccessful = true;
	public static long lastReadWrite = 0l;
	
	private static String file = "./options.properties";
	private static File f;
	
	static {
		//add default settings here
		p.setProperty("defaultSpeed", "1");
	}
	
	public static void init() {
		lastReadWrite = System.currentTimeMillis();
		f = new File(file);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		if(!f.exists()) {
			try {
				f.createNewFile();
				fos = new FileOutputStream(f);
				writeProperties(fos);
			} catch(IOException ioe) {
				readSuccessful = false;
			}
		}
		try {
			fis = new FileInputStream(f);
			p.load(fis);
		} catch(IOException ioe) {
			readSuccessful = false;
		}
		
	}
	
	public static void writeProperties(FileOutputStream fos) throws IOException {
		p.store(fos, null);
		lastReadWrite = System.currentTimeMillis();
	}
	
}

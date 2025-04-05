package com.Ecommerce.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author AMAN
 */

public class FileUtility {

	/*
	 * this method will read the data from Property file
	 * 
	 * @ String file path
	 * 
	 * @ String key
	 */
	public String getDataFromProperty(String filePath, String key) throws IOException {
		FileInputStream f = new FileInputStream(filePath);
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
	}
}

package com.devs.issuetracker.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class PropertyValueLoader {
	private static final Logger logger = Logger.getLogger(PropertyValueLoader.class);
	private static final String propFileName = "config.properties";
	
	public static String getPropValue(String property) throws IOException {
		String result = "";
		InputStream inputStream = null;
		try {
			Properties prop = new Properties();
			inputStream = PropertyValueLoader.class.getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			result = prop.getProperty(property);
			if(logger.isInfoEnabled()) logger.info("found property: " + result);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}

}

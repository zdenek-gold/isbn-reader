package org.zigi.tool.isbnreader.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {

	private static final String PROPERTY_FILE = "config.properties";
	private static Properties PROPERTY;
	static {

		InputStream inputStream = null;
		try {
			PROPERTY = new Properties();
			inputStream = Util.class.getClassLoader().getResourceAsStream(PROPERTY_FILE);

			if (inputStream != null)
				PROPERTY.load(inputStream);
		} catch (Exception e) {

		} finally {
			if (inputStream != null)
				try {
					inputStream.close();
				} catch (IOException e) {
				}
		}
	}

	/**
	 * Return value of application property key
	 * 
	 * @param key
	 * @return
	 */
	public static String property(String key) {
		return PROPERTY.getProperty(key);
	}
}

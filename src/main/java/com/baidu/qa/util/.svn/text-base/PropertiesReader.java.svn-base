package com.baidu.qa.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.WeakHashMap;

/**
 * Helper class to read dot properties file.
 * 
 * @author liangxiaowu
 * 
 */
public class PropertiesReader {

	private static Map<String, Properties> filePropMapping = new WeakHashMap<String, Properties>();

	public static String getValue(String file_name, String key) throws MissingResourceException {
		final ResourceBundle res = ResourceBundle.getBundle(file_name);
		String value = res.getString(key);
		return value.trim();
	}

	public static Properties fillProperties(String file_name) throws MissingResourceException {

		if (!file_name.endsWith(".properties")) {
			file_name = file_name + ".properties";
		}
		return getProperties(file_name);
	}

	public static Properties getProperties(String fileName) {

		return getProperties(fileName, PropertiesReader.class.getClassLoader());
	}

	public static Properties getProperties(String fileName, ClassLoader cl) {

		Properties properties = new Properties();

		if (filePropMapping.containsKey(fileName)) {
			properties = filePropMapping.get(fileName);
		} else {
			InputStream is = cl.getResourceAsStream(fileName);
			try {
				try {
					properties.load(is);
				} catch (IOException e) {
					throw new RuntimeException("load properties file error", e);
				}
				filePropMapping.put(fileName, properties);
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					throw new RuntimeException("load properties file error", e);
				}
			}

		}
		return properties;
	}
}

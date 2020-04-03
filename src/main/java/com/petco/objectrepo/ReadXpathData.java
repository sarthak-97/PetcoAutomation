package com.petco.objectrepo;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 ********** reads all the xpaths required for the automation
 * 
 * @author sarthak-pc
 *
 */
public class ReadXpathData {

	public Properties getXpaths() throws IOException {

		FileReader file = new FileReader("src/main/resources/property_files/Xpaths.properties");

		Properties prop = new Properties();
		prop.load(file);

		return prop;
	}

}

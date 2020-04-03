package com.petco.testdata;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Reading WebDriver Properties
 * 
 * @author sarthak-pc
 *
 */
public class DriverProperties {

	private String url;
	private String webdriver;
	private String driverpath;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWebdriver() {
		return webdriver;
	}

	public void setWebdriver(String webdriver) {
		this.webdriver = webdriver;
	}

	public String getDriverpath() {
		return driverpath;
	}

	public void setDriverpath(String driverpath) {
		this.driverpath = driverpath;
	}

	public DriverProperties() throws IOException {

		FileReader file = new FileReader("src/main/resources/property_files/WebDriver.properties");
		Properties prop = new Properties();

		prop.load(file);

		url = prop.getProperty("Url");
		driverpath = prop.getProperty("driverpath");
		webdriver = prop.getProperty("webdriver");

	}

}

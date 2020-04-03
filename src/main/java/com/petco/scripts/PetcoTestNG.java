package com.petco.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.petco.library.GenerateLogFile;
import com.petco.library.PetcoLibrary;
import com.petco.testdata.DriverProperties;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author sarthak-pc
 *
 */
public class PetcoTestNG {

	static WebDriver driver;

	@BeforeClass
	public void beforeClass() throws IOException {

		DriverProperties prop = new DriverProperties();
		GenerateLogFile log = new GenerateLogFile();
		log.generateLogFile();
		
		System.setProperty(prop.getWebdriver(), prop.getDriverpath());
		driver = new ChromeDriver();
		driver.get(prop.getUrl());
		driver.manage().window().maximize();
	}

	@Test
	public void automatePetco() throws IOException, InterruptedException {

		PetcoLibrary petcoLib = new PetcoLibrary();
		petcoLib.selectFoodCategory(driver);
		petcoLib.sortFoodAlphabetically(driver);
		petcoLib.sortByPrice(driver);
		petcoLib.goToHomePage(driver);

	}

	@AfterClass
	public void afterClass() {

		driver.close();
	}

}

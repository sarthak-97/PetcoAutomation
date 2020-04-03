package com.petco.library;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.petco.objectrepo.ReadXpathData;

/**
 * 
 * @author sarthak-pc
 *
 */
public class PetcoLibrary {

	ReadXpathData xpath = new ReadXpathData();
	TakeScreenShot screenshot = new TakeScreenShot();
	

	public void selectFoodCategory(WebDriver driver) throws IOException, InterruptedException {

		screenshot.getScreenshot(driver,driver.getTitle());
		// **************clickiing the dog link**************
		driver.findElement(By.xpath(xpath.getXpaths().getProperty("xPath_HomePage_DogLink"))).click();
		Thread.sleep(500);
	/*	
		WebElement adImg= driver.findElement(By.xpath(xpath.getXpaths().getProperty("XPath_ad")));
		
		if(adImg.isDisplayed()) {
			
			adImg.click();
		}*/
		
		// **************clicking the food category***************
		driver.findElement(By.xpath(xpath.getXpaths().getProperty("xPath_category_foodLink"))).click();
		Thread.sleep(1600);
		
		// ***************** clicking the sub category as vet food***********
		driver.findElement(By.xpath(xpath.getXpaths().getProperty("xPath_subcategory_foodLink"))).click();
		Thread.sleep(1600);
	}

	public void sortFoodAlphabetically(WebDriver driver) throws IOException, InterruptedException {

		Select sortOrder = new Select(
				driver.findElement(By.xpath(xpath.getXpaths().getProperty("xPath_food_category_sort"))));
		sortOrder.selectByVisibleText("Name A-Z");
		screenshot.getScreenshot(driver,"SortByA-Z");
		Thread.sleep(3000);

		String productName = driver
				.findElement(By.xpath(xpath.getXpaths().getProperty("xPath_food_category_sort_name"))).getText();
		String priceOfProduct = driver
				.findElement(By.xpath(xpath.getXpaths().getProperty("xPath_food_category_sort_price"))).getText();

		System.out.println("The name of the second product is " + productName + " and the price of the product is "
				+ priceOfProduct);

	}
	
	
	public void sortByPrice(WebDriver driver) throws IOException, InterruptedException {
		
		//***** getting in range of 10 to 25 $
		driver.findElement(By.xpath(xpath.getXpaths().getProperty("xpath_price_category"))).click();
		
		Thread.sleep(2000);
		screenshot.getScreenshot(driver,"rangeSelected");
		//*************sorting high to low ***************
		Select sortOrder = new Select(
				driver.findElement(By.xpath(xpath.getXpaths().getProperty("xPath_food_category_sort"))));
		sortOrder.selectByVisibleText("Price High to Low");
		screenshot.getScreenshot(driver,"rangeSelectedHighToLow");
		Thread.sleep(3000);
		
		String productName= driver.findElement(By.xpath(xpath.getXpaths().getProperty("XPath_sort_price_prodName"))).getText();
		String price=driver.findElement(By.xpath(xpath.getXpaths().getProperty("XPath_sort_price_prodPrice"))).getText();
		
		System.out.println("The name of the first product is " + productName + " and the price of the product is "
				+ price);
		
		
	}
	
	
	public void goToHomePage(WebDriver driver) throws IOException {
		
		//clicking the image for going back to homepage
		
		System.out.println("going back to home page");
		
		driver.findElement(By.xpath(xpath.getXpaths().getProperty("XPath_petco_image"))).click();;
		
		screenshot.getScreenshot(driver,"exiting");
		
	}

}

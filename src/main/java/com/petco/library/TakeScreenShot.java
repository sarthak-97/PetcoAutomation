package com.petco.library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakeScreenShot {

	public void getScreenshot(WebDriver driver, String screenshotId) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File DestFile = new File("src/main/resources/screenshots/" + screenshotId + ".jpg");
		// Copy file at destination
		Files.copy(file, DestFile);

		// System.out.println(screenshot);
	}

}

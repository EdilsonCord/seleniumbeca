package com.everis.beca;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGoogle {
	static WebDriver driver;

	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testHello() {
		driver.manage().window().maximize();
		driver.get("https://google.com");
		assertEquals(driver.getTitle(), "Google");
	}
	
	@Test
	public void pesquisarPorEveris() {
		By locator = By.xpath("/html/body/div[2]/div[2]/form/div[2]/div[1]/div[1]/div/div[2]/input");
		WebElement pesquisar = driver.findElement(locator);
		pesquisar.sendKeys("everis");
	}
	
	@After
	public void takeScreenshot() throws IOException{
		SimpleDateFormat formatoDeData = new SimpleDateFormat("yyyyMMdd-HHmmss-SSSS");
		String fileName = formatoDeData.format(new Date());
		String shotName = String.format("%s.png", fileName);
		File finalShotFile = new File("C:\\cursoSelenium\\exemploSelenium\\screenshots", shotName);
		File shotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shotFile, finalShotFile);
	}
	
		
	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}
}

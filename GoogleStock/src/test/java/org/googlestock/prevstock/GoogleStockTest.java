package org.googlestock.prevstock;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class GoogleStockTest {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91890\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/finance/");
		driver.manage().deleteAllCookies();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void getLastGoogleFinance() throws InterruptedException {

		// code to serach the google ticker
		WebElement elemet = driver.findElement(By.xpath("(//input[@aria-label='Search for stocks, ETFs & more'])[2]"));
		elemet.sendKeys("Google");
		elemet.sendKeys(Keys.ENTER);
		//useing sleep for 6 sec to load all the web elements
		Thread.sleep(6000);
		
		String value;
		//xpath to fine the value of prev google price
		WebElement element = driver.findElement(By.xpath("//div[@class='pFZ9G']"));
		
		value = element.getText();
		System.out.println("Valueof prev close : "+value);
		Assert.assertEquals("Prev close $137.75", value);
		System.out.println("This run is from git push from local to master."); 
	}
}

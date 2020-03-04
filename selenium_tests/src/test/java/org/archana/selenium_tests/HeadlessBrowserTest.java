package org.archana.selenium_tests;

import org.archana.selenium_main.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowserTest {
	WebDriver driver;
	@Test
	public void browserTest() throws IOException {

//	  ChromeOptions options=new ChromeOptions();
//	  options.addArguments("winow-size=1400,800");
//	  options.addArguments("headless");
//	 WebDriverManager.firefoxdriver().setup();
//	 WebDriver driver=new FirefoxDriver();
//	  WebDriverManager.chromedriver().setup();
//	  WebDriver driver=new ChromeDriver(options);
//	  WebDriverManager.iedriver().setup();
//	  WebDriver driver=new InternetExplorerDriver();
//	  WebDriver driver=new HtmlUnitDriver();
		Properties properties = new Properties();
		FileInputStream fileinput = new FileInputStream(
				"C:\\Users\\ArchanaVeeru\\eclipse-workspace\\selenium_tests\\src\\Config.properties");
		properties.load(fileinput);
		String username = properties.getProperty("user_name");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		String browser = properties.getProperty("browser");
		System.out.println(username);
		System.out.println(password);
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		 else if(browser.equalsIgnoreCase("ff")) {
		 WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver();
		 

		 }
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
	 driver.findElement(By.linkText("Images")).click();
	String title= driver.getTitle();
	System.out.println(title);
	}
}

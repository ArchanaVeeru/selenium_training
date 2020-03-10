/**
 * 
 */
package org.archana.selenium_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ArchanaVeeru
 *
 */
public class FirefoxHeadless {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FirefoxBinary fo=new FirefoxBinary();
//		fo.addCommandLineOptions("--headless");
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver=new FirefoxDriver();
//		FirefoxOptions options=new FirefoxOptions();
//		options.setBinary(fo);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		System.out.println(driver.getCurrentUrl());
		

	}

}

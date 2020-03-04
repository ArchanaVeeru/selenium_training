package org.archana.selenium_tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Js_Alert {
  @Test
  public void alertJs() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://classic.crmpro.com/");
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("alert('agree to privacy policy')");
	  Thread.sleep(2000);
	  Alert alert=driver.switchTo().alert();
	  alert.accept();
  }
}

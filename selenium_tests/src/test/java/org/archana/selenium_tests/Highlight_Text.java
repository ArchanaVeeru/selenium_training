package org.archana.selenium_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Highlight_Text {
	static WebDriver driver;
  @Test
  public void highlightText() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("https://classic.crmpro.com/");
	  WebElement element=driver.findElement(By.name("username"));
	  WebElement element1=driver.findElement(By.name("password"));
	 // WebElement element=driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
	 // highlight(driver,element);
  JavascriptExecutor js=((JavascriptExecutor)driver);
 // for(int i=0;i<100;i++)
//  {
//**  js.executeScript("arguments[0].setAttribute('style','background:yellow; border:3px solid blue;');", driver.findElement(By.linkText("Sign Up")));
  
  js.executeScript("arguments[0].style.backgroundColor='rgb(200,0,0)'", element);
  js.executeScript("arguments[0].style.border='3px solid blue'", element);
  js.executeScript("arguments[0].style.backgroundColor='rgb(200,0,0)'", element1);
//  }
  element.sendKeys("Hello");
  element1.sendKeys("Heko");
  }
	
  
//	  public static void highlight(WebDriver driver,WebElement element) {
//	 // JavascriptExecutor js=((JavascriptExecutor)driver);
//	  String bgcolor=element.getCssValue("backgroundColor");
//	  for(int i=0;i<100;i++) {
//	  changeColor("rgb(200,0,0)",element,driver);
//	  changeColor(bgcolor,element,driver);
//	  }
//	  
//	  }
//	 public static void changeColor(String color,WebElement element,WebDriver driver)
//	 {
//		  JavascriptExecutor js=((JavascriptExecutor)driver);
//		  js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
//	 }
  
  
}

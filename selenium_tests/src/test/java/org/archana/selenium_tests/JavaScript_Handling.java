package org.archana.selenium_tests;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScript_Handling {
	WebDriver driver;
	static JavascriptExecutor js;
  @Test
  public void JavaScript()  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://classic.crmpro.com/");
	  WebElement element=driver.findElement(By.name("username"));
	  WebElement element1=driver.findElement(By.name("password"));
	  element.sendKeys("archanaveeru");
	  element1.sendKeys("veeru143");
	  WebElement submit=driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
	  highlight(driver,submit);
	 // Thread.sleep(3000);
	  clickElements(driver,submit);
	 // refresh(driver);
	  js=(JavascriptExecutor)driver;
	  String domain=js.executeScript("return document.domain").toString();
	  System.out.println("domain name  : "+domain);
      String title=js.executeScript("return document.title;").toString();
	  System.out.println("title name : "+title);
	  String url=js.executeScript("return document.URL").toString();
	  System.out.println("url name : "+url);
	  String innertext=js.executeScript("return document.documentElement.innerText;").toString();
	  System.out.println("innertext  : "+innertext);
	  driver.manage().window().maximize();
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	 // js.executeScript(("window.scrollBy(0,1000)"));
	  
	  
	  
  }
  
 
  public static void highlight(WebDriver driver,WebElement element)
  {
	 js =((JavascriptExecutor)driver);
	 for(int i=0;i<100;i++) {
	  js.executeScript("arguments[0].style.backgroundColor='rgb(200,0,0)'",element);
	 }
  }
  
  public static void clickElements(WebDriver driver,WebElement element)
  {
	  js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click()", element);
  }
  public static void refresh(WebDriver driver)
  {
	  js=(JavascriptExecutor)driver;
	  js.executeScript("window.location='http://www.google.com/'");
	  js.executeScript("history.go(0)");
  }
//  @AfterMethod
//  public void tearDown()
//  {
//	  driver.quit();
//  }
//  
}

package org.archana.selenium_tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
  @Test
  public void links() throws MalformedURLException, IOException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.facebook.com/");
//	  driver.get("https://classic.crmpro.com/");
//	  driver.findElement(By.name("username")).sendKeys("archanaveeru");;
//	  driver.findElement(By.name("password")).sendKeys("veeru143");
//	  driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
	  List <WebElement> list=driver.findElements(By.tagName("a"));	 
	  list.addAll(driver.findElements(By.tagName("img")));
	  System.out.println(list.size());
	  List <WebElement> activelinks=new ArrayList<WebElement>();
	  for(int i=0;i<list.size();i++) {
		  System.out.println(list.get(i).getAttribute("href"));
		  if(list.get(i).getAttribute("href")!=null &&(!list.get(i).getAttribute("href").contains("javascript")))
		  {
			  activelinks.add(list.get(i));
		  }
	  }
		  System.out.println("size of active links  "+activelinks.size());
		  for(int j=0;j<activelinks.size();j++)
		  {
			  HttpURLConnection connection=(HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			  connection.connect();
			  String response=connection.getResponseMessage();
			  connection.disconnect();
			  System.out.println(activelinks.get(j).getAttribute("href")+" ----- "+response);
			  
		  }
	  }
	  
  }


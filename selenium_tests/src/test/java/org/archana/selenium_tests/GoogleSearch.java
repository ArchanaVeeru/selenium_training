package org.archana.selenium_tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
  @Test
  public void search() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().fullscreen();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.get("https://www.google.com/");
	  driver.findElement(By.name("q")).sendKeys("testing");
	 List <WebElement> element= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
	 System.out.println("number of"+element.size());
	 for(int i=0;i<element.size();i++)
	 {
		 System.out.println(element.get(i).getText());
		 if(element.get(i).getText().contains("testing for ms"))
		 {
			 element.get(i).click();
			 break;
		 }
	 }
  }
}

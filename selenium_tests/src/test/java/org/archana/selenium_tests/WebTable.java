package org.archana.selenium_tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
  @Test
  public void dynamicWebTable() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://classic.crmpro.com/");
	  driver.findElement(By.name("username")).sendKeys("archanaveeru");;
	  driver.findElement(By.name("password")).sendKeys("veeru143");
	  driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
	  driver.switchTo().frame("mainpanel");
	 // driver.switchTo().frame("coToolbarFrame");
	  driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a")).click();
	  //*[@id="vContactsForm"]/table/tbody/tr[5]/td[1]/input
	//*[@id="vContactsForm"]/table/tbody/tr[6]/td[1]/input
	//*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
	//*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
//	  String before_xpath="//*[@id='vContactsForm']/table/tbody/tr[";
//	  String after_xpath="]/td[2]/a";
//	  for(int i=4;i<7;i++)
//	  {
//		//*[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
//		 String name=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
//		 System.out.println(name);
//		 if(name.contains("Hema Malini"))
//		 {
//			//*[@id="vContactsForm"]/table/tbody/tr[5]/td[1]	 
//			 driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr["+i+"]/td[1]/input")).click();
//					 }
//	  }
	  driver.findElement(By.xpath("//a[contains(text(),'Hema Malini')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
  }
}

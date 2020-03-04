package org.archana.selenium_tests;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {
	@Test
	public void calendar1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://www.airindia.in/");
//		driver.findElement(By.name("username")).sendKeys("archanaveeru");;
//		  driver.findElement(By.name("password")).sendKeys("veeru143");
//		  driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
//		  driver.switchTo().frame("mainpanel");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.id("bdMainSite"))).build().perform();
		  WebElement element=driver.findElement(By.id("_depdateeu1"));
		 
		  String dateval="28-02-2020";
		  
		  selectdate(dateval,element,driver);
		  
		
	}
	public static void selectdate(String dateval,WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',"+dateval+");",element);
		
	}
//  @Test
//  public void calendar() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://classic.crmpro.com/");
//		driver.findElement(By.name("username")).sendKeys("archanaveeru");;
//		  driver.findElement(By.name("password")).sendKeys("veeru143");
//		  driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
//	  String date="18-February-2014";
//	  String dateArr[]=date.split("-");
//	  String day=dateArr[0];
//	  String month=dateArr[1];
//	  String year=dateArr[2];
//	  driver.switchTo().frame("mainpanel");
//	  Select select=new Select(driver.findElement(By.xpath("//*[@name='slctMonth']")));
//	  select.selectByVisibleText(month);
//	  Select select1=new Select(driver.findElement(By.xpath("//*[@name='slctYear']")));
//	  select1.selectByVisibleText(year);
//	//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]
//	//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]
//	  
//	//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]
//	//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]
//	  String before_xpath="//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
//	  String after_xpath="]/td[";
//	  boolean flag=false;
//	  for(int rownum=1;rownum<6;rownum++)
//	  {
//		  for(int colnum=1;colnum<7;colnum++)
//		  {
//			  String dayval=driver.findElement(By.xpath(before_xpath+rownum+after_xpath+colnum+"]")).getText();
//			if(dayval.contentEquals(day))
//			{
//				driver.findElement(By.xpath(before_xpath+rownum+after_xpath+colnum+"]")).click();
//				flag=true;
//				break;
//			}
//		  }
//		  if(flag)
//			  break;
//	  }
//	  
//  }
}

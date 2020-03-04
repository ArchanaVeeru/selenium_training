package org.archana.selenium_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDown {
  @Test
  public void DropDown() {
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		//driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		//driver.findElement(By.id("dropdownMenuButton")).click();
		driver.findElement(By.xpath("//button[@title='HTML, CSS']")).click();
		driver.findElement(By.xpath("//label//input[@value='jQuery']")).click();
  }
}

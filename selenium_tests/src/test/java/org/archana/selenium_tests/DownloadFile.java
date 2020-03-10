package org.archana.selenium_tests;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {
	WebDriver driver;
	File folder;
  @SuppressWarnings("deprecation")
@BeforeMethod
  public void setUp() {
	  folder=new File(UUID.randomUUID().toString());
	  folder.mkdir();
	  
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options=new ChromeOptions();
	  
	  Map <String, Object> prefs=new HashMap<String, Object>();
	  prefs.put("profile.default_content_settings.popups",0);
	  prefs.put("download.default_directory",folder.getAbsolutePath());
	  
	  options.setExperimentalOption("prefs",prefs);
	  DesiredCapabilities cap=DesiredCapabilities.htmlUnit();
	  cap.setCapability(ChromeOptions.CAPABILITY,options);
	  driver=new ChromeDriver(cap);
  }
 @Test
 public void downloadFileTest() {
	 driver.get("https://the-internet.herokuapp.com/download");
	 driver.findElement(By.linkText("sample.jpg")).click();
	 File listOffFiles[]=folder.listFiles();
	 Assert.assertTrue(listOffFiles.length>0);
	 for(File file:listOffFiles) {
		  Assert.assertTrue(file.length()>0); 
 }
 }
  @AfterMethod
 
public void tearDown() {
	// TODO Auto-generated method stub
	driver.quit();
	
//	for(File file : folder.listFiles())
//	{
//		file.delete();
//	}
//	folder.delete();
}
}

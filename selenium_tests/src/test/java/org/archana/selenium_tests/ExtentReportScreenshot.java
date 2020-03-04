package org.archana.selenium_tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportScreenshot {
	  public WebDriver driver;
	  public ExtentReports extent;
	  public ExtentTest extentTest;
	  
	  @BeforeTest
	  public void setExtent() {
		  extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
		  extent.addSystemInfo("ArchanaVeeru","");
		  extent.addSystemInfo("ArchanaVeeru","");
		  extent.addSystemInfo("ArchanaVeeru","");
	  }

	  @AfterTest
	  
		  
	  public void endReport() {
		  extent.flush();
		  extent.close();
	  }
	  public static String getScreenshot(WebDriver driver,String ScreenshotName) throws IOException {
		  String dateName=new SimpleDateFormat("yyyyMMddmmss").format(new Date());
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File source=ts.getScreenshotAs(OutputType.FILE);
		  String destination=System.getProperty("user.dir")+"/FailedScreenshot/"+ScreenshotName+dateName+".png";
		  File finalDestination=new File(destination);
		 FileUtils.copyFile(source, finalDestination);
		 return destination;
		  
	  }
	  @BeforeMethod
	  public void setUp() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.get("https://classic.crmpro.com/");
	  }
  @Test
  public void extentreport() {
	extentTest =extent.startTest("extentreport");
	String title=driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
		  
  }
  @AfterMethod
  public void tearDown(ITestResult result)throws IOException{
	  if(result.getStatus()==ITestResult.FAILURE) {
		  extentTest.log(LogStatus.FAIL,"Test cas Failed is"+result.getName());
		  extentTest.log(LogStatus.FAIL,"Test cas Failed is"+result.getThrowable());
		  String screenshotpath=ExtentReportScreenshot.getScreenshot(driver,result.getName());
		  extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(screenshotpath));
	  }
	  else if(result.getStatus()==ITestResult.SKIP) {
		  extentTest.log(LogStatus.SKIP,"Test case skipped is"+result.getName());
	  }
	  else if(result.getStatus()==ITestResult.SUCCESS) {
		  extentTest.log(LogStatus.PASS,"Test case passed is"+result.getName());
	  }
	  extent.endTest(extentTest);
	  driver.quit();
  }
}

package org.archana.selenium_tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpeedupScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		ChromeOptions options=new ChromeOptions();
		disableImageChrome(options);
		driver.get("http://www.amazon.com/");
	}
public static void disableImageChrome(ChromeOptions options)
{
	HashMap<String, Object> images=new HashMap<String,Object>();
	images.put("images",2);
	HashMap<String, Object> pref=new HashMap<String,Object>();
	pref.put("profile.default_content_setting_values",images);
	options.setExperimentalOption("prefs",pref);
}
}

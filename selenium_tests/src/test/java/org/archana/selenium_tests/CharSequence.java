/**
 * 
 */
package org.archana.selenium_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ArchanaVeeru
 *
 */
public class CharSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		StringBuilder username=new StringBuilder().append("Hello").append(" ").append("how");
		StringBuffer userinfo=new StringBuffer().append(" ").append("are").append(" ");
		String user="you";
		driver.findElement(By.id("email")).sendKeys(username, userinfo, user);
	}

}

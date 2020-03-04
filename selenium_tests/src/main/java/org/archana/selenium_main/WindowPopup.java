/**
 * 
 */
package org.archana.selenium_main;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ArchanaVeeru
 *
 */
public class WindowPopup {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.popuptest.com/goodpopups.html");
        driver.findElement(By.linkText("Good PopUp #2")).click();
        Set <String> handler=driver.getWindowHandles();
        Iterator <String> it=handler.iterator();
        String parentwindow=it.next();
        System.out.println("parent window id is"+parentwindow);
       String childwindow=it.next();
       System.out.println("childwinodw id is"+childwindow);
       driver.switchTo().window(childwindow);
       Thread.sleep(2000);
       driver.close();
       driver.switchTo().window(parentwindow);
       System.out.println("parent window title is"+driver.getTitle());
      
        
	}

}

package com.sg.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWrapper {
	
public static WebDriver driver;

public static void LaunchBrowser()
{
	WebDriverManager.chromedriver().setup(); 
	WebDriverManager.firefoxdriver().setup(); 
	WebDriverManager.iedriver().setup(); 

	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
}
	
	@After
	public void end()
	{
		WebDriverWrapper.driver.quit();
	}
	

}

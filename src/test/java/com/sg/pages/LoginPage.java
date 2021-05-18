package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	private static By usernamelocator = By.xpath("//*[text()='Username:']/following::input");
	private static By passwordlocator = By.xpath("//*[text()='Password:']/following::input");
	private static By languagelocator = By.name("languageChoice");
	private static By loginlocator = By.xpath("//button[@type='submit']");
	private static By errorlocator = By.xpath("//div[@class='alert alert-danger login-failure m-1']");
	
	
	public static void enterUsername(WebDriver driver, String username)
	{
		driver.findElement(usernamelocator).sendKeys(username);
	}
	
	public static void enterPassword(WebDriver driver, String password) 
	{
		driver.findElement(passwordlocator).sendKeys(password);

	}
	
	public static void selectLanguageByText(WebDriver driver, String language)
	{
		Select selectLanguage=new Select(driver.findElement(languagelocator));
        selectLanguage.selectByVisibleText(language);
	}
	
	public static void clickOnLogin(WebDriver driver)
	{
		driver.findElement(loginlocator).click();

	}
	
	public static String getLoginErrorMessage(WebDriver driver)
	{
		return driver.findElement(errorlocator).getText().trim();
	}

}

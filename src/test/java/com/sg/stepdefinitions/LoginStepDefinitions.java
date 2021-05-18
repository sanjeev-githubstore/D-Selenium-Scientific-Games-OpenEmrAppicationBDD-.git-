package com.sg.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sg.base.WebDriverWrapper;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinitions {
	
	public static WebDriver driver;
	
	@Given("I have browser with Open EMR page")
	public void i_have_browser_with_open_emr_page()
	{
		WebDriverWrapper.LaunchBrowser();
	}
	
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) 
	{
		driver.findElement(By.id("authUser")).sendKeys(username);
	}
	
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) 
	{
		driver.findElement(By.id("clearPass")).sendKeys(password);
	}
	
	@When("I select language as {string}")
	public void i_select_language_as(String language) 
	{
		Select selectlanguage = new Select(driver.findElement(By.name("languageChoice")));
		selectlanguage.selectByVisibleText(language);
	}
	
	@When("I click on login")
	public void i_click_on_login() 
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Then("I should get access to the dashboard with title {string}")
	public void i_should_get_access_to_the_dashboard_with_title(String expectedValue)
	{
		Assert.assertEquals(expectedValue, driver.getTitle());

	}
	
	@Then("I should get the error message {string}")
	public void i_should_get_the_error_message(String expectedValue) 
	{
		Assert.assertEquals(expectedValue, driver.
				findElement(By.xpath("//div[@class='alert alert-danger login-failure m-1']")).getText());   
	}
	
	@After
	public void end()
	{
		driver.quit();
	}

}

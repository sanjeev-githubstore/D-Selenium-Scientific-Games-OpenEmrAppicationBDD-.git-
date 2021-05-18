package com.sg.stepdefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import io.cucumber.datatable.DataTable;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.DashboardPage;

import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientStepDefinitions {
	
	ChromeDriver driver = new ChromeDriver();
	
	@When("I mousehover on patient-client")
	public void i_mousehover_on_patient_client() 
	{
		DashboardPage.hoverOnPatientClient(driver);
	}
	
	@When("I click on patients")
	public void i_click_on_patients() 
	{
		driver.findElement(By.xpath("//*[text()='Patients']")).click();
	}
	
	@When("I click on add new patient")
	public void i_click_on_add_new_patient() 
	{
		driver.switchTo().frame("fin");
		driver.findElement(By.id("create_patient_btn1")).click();
		driver.switchTo().defaultContent();
	}
	
	@When("I fill the patient detail")
	public void i_fill_the_patient_detail(DataTable dataTable) 
	{
      System.out.println(dataTable);
      
      List<Map<String,String>> ls = dataTable.asMaps();
      
      System.out.println(ls.get(0).get("fristname"));
      System.out.println(ls.get(0).get("lastname"));
      System.out.println(ls.get(0).get("dob"));
      System.out.println(ls.get(0).get("gender"));

      WebDriverWrapper.driver.switchTo().frame("pat");
      WebDriverWrapper.driver.findElement(By.id("form_fname")).sendKeys(ls.get(0).get("fristname"));
      WebDriverWrapper.driver.findElement(By.id("form_lname")).sendKeys(ls.get(0).get("lastname"));
      WebDriverWrapper.driver.findElement(By.id("form_DOB")).sendKeys(ls.get(0).get("dob"));
      
      Select sex = new Select(WebDriverWrapper.driver.findElement(By.id("form_sex")));
      sex.selectByVisibleText(ls.get(0).get("gender"));
      
	}
	
	@When("I click on create new patient")
	public void i_click_on_create_new_patient() 
	{
	    
	}
	
	@When("I click on confirm create new patient")
	public void i_click_on_confirm_create_new_patient() 
	{
	    
	}
	
	@When("I handle alert")
	public void i_handle_alert()
	{
	    
	}
	
	@When("I close happy birthday pop up when available")
	public void i_close_happy_birthday_pop_up_when_available()
	{
	   
	}
	
	@When("I validate alert message receiver {string}")
	public void i_validate_alert_message_receiver(String string) 
	{
	    
	}
	
	@When("I validate the added patient detail {string}")
	public void i_validate_the_added_patient_detail(String string) 
	{
	    
	}


}

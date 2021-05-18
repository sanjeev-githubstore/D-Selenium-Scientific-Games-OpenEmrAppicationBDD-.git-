package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	private static By logoutLocator=By.xpath("//*[text()='Logout']");
	private static By patientlocator=By.xpath("//*[text()='Patients']");
    private static By patientclientlocator=By.xpath("//*[@data-bind='text:label']");
    private static By framelocator=By.xpath("//*[@src='/b/openemr/interface/main/finder/dynamic_finder.php']");
    private static By addnewpatientlocator=By.id("create_patient_btn1");
    private static By selectttitlelocator=By.id("form_title");
    private static By firstnamelocator=By.id("form_fname");
    private static By lastnamelocator=By.id("form_lname");
    private static By dateofbirthlocator=By.id("form_DOB");
    private static By formsexlocator=By.id("form_sex");
    private static By createnewpatientlocator=By.id("create");
    private static By confirmcreatenewpatientlocator=By.xpath("//input[@value='Confirm Create New Patient']");
    private static By patientnamelocator=By.xpath("[//*[contains(text(),'Medical Record Dashboard']");
    
    
    public static void waitForPresenceOfLogout(WebDriver driver)
    {
        WebDriverWait wait=new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutLocator));
    }
    
    public static String getCurrentTitle(WebDriver driver)
    {
        return driver.getTitle().trim();
        
    }
    
    public static void hoverOnPatientClient(WebDriver driver)
    {	
    	Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(patientclientlocator)).perform();
    }
    
    public static void clickonPatient(WebDriver driver)
    {
		driver.findElement(patientlocator).click();

    }
    
    public static void switchframe(WebDriver driver)
    {
        driver.switchTo().frame(driver.findElement(framelocator));

    }
    
    public static void clickOnAddNewPatient(WebDriver driver)
    {
    	driver.findElement(addnewpatientlocator).click();
    }
    
    public static void defaultContent(WebDriver driver)
    {
    	driver.switchTo().defaultContent();
    }
    
    public static void patientFrame(WebDriver driver)
    {
    	driver.switchTo().frame("pat");
    }
    
    public static void selectTitle(WebDriver driver)
    {
    	Select formtitle = new Select(driver.findElement(selectttitlelocator));
		formtitle.selectByVisibleText("Mr.");
    }
    
    public static void enterFirstName(WebDriver driver, String firstname)
	{
		driver.findElement(firstnamelocator).sendKeys(firstname);
	}
    
    public static void enterLastName(WebDriver driver, String lastname)
	{
		driver.findElement(lastnamelocator).sendKeys(lastname);
	}
    
    public static void enterDateOfBirth(WebDriver driver, String dateofbirth)
	{
		driver.findElement(dateofbirthlocator).sendKeys(dateofbirth);
	}
    
    public static void enterFormSex(WebDriver driver, String formsex)
	{
    	Select sex = new Select(driver.findElement(formsexlocator));
		sex.selectByVisibleText(formsex);
	}
    
    public static void clickOnCreateNewPatient(WebDriver driver)
	{
    	driver.findElement(createnewpatientlocator).click(); 
    	
	}
    
    public static void defaultFrame(WebDriver driver)
    {
    	driver.switchTo().defaultContent();
    }
    
    public static void modalFrame(WebDriver driver)
    {
		driver.switchTo().frame("modalframe");
    }
    
    public static void confirmCreateNewPatient(WebDriver driver)
	{
    	driver.findElement(confirmcreatenewpatientlocator).click(); 
    	
	}

    public static void switchToDefaultFrame(WebDriver driver)
    {
    	driver.switchTo().defaultContent();
    }
    
    public static void webdriverWait(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
    }
    
    public static void getAlertText(WebDriver driver)
	{
    	String alertText=driver.switchTo().alert().getText();
		System.out.println(alertText);
	}

    
    public static void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();

	}

    public static String getPatientName(WebDriver driver)
	{
    	return driver.findElement(patientnamelocator).getText().trim();
           
	}
    
    
    
}

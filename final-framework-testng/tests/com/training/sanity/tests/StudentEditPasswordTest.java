package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
 import com.training.pom.StudentEditPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class StudentEditPasswordTest {
	
	private WebDriver driver;
	private String baseUrl;
	private StudentEditPasswordPOM studentPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
  
  @BeforeClass
	public void setUp() throws Exception {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		studentPOM = new StudentEditPasswordPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

  @AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
 
  //Login with Current Username and password for student profile
  @Test(priority=1)
	public void studentLoginTest() {
		studentPOM.sendUserName("swapna9");
		studentPOM.sendPassword("Gautham@123");
		studentPOM.clickLoginBtn(); 
		studentPOM.clickEditProfile();
		screenShot.captureScreenShot("First");
	}
  
  //Edit student profile and change the password
  @Test(dependsOnMethods="studentLoginTest", priority=2)
	public void editPasswordTest() {
	    studentPOM.sendOldPassword("Gautham@123");
		studentPOM.sendNewPassword("Gautham@143");
		studentPOM.sendConfPassword("Gautham@143");
		studentPOM.clickSaveBtn(); 
		screenShot.captureScreenShot("second");
		String expectedText = "Your new profile has been saved";
		WebElement actual = driver.findElement(By.xpath("//DIV[@class='alert alert-info'][text()='Your new profile has been saved']"));
		String actualText = actual.getText();
		assertEquals(actualText, expectedText);
	}

}

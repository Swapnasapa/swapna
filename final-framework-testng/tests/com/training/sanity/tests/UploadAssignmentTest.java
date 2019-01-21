package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.UploadAssignmentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class UploadAssignmentTest {
	private WebDriver driver;
	private String baseUrl;
	private UploadAssignmentPOM uploadPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
  
  @BeforeClass
	public void setUp() throws Exception {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		uploadPOM = new UploadAssignmentPOM(driver); 
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
  
  //Student should be able to login to elearning home page
  @Test(priority=1)
   public void studentLogin()
   {
	    uploadPOM.sendUserName("swapna9");
	    uploadPOM.sendPassword("Gautham@123");
	    uploadPOM.clickLoginBtn(); 
	    String expected = "Profile";
	    String actual = driver.findElement(By.linkText("Profile")).getText();
	    assertEquals(actual, expected);
   }
  
  //Student should be able to click on particular course and take test
  @Test(priority=2, dependsOnMethods="studentLogin")
   public void uploadAssignment() 
   {  
	    uploadPOM.clickOnCourses();
	    uploadPOM.sendSearchCourse("SELENIUM PROJECT");
	    uploadPOM.clickSearchBtn();
	    uploadPOM.clickCourseLink();
	    uploadPOM.clickOnAssignmentsLink();
	    uploadPOM.clickAvailAssignments();
	    uploadPOM.uploadAssignment();
	    uploadPOM.clickAvailAssignments();
	     
	    screenShot.captureScreenShot("UploadAssignment");
	    String expected = "Assignment.docx";
	    String actual = driver.findElement(By.xpath("//*[@id=\"77\"]/td[2]/div")).getText();
	    Assert.assertEquals(actual, expected);
	   
	   
   }
  

}

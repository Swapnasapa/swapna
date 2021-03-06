package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.StudentTakeTestPOM;
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

public class StudentTakeTest {
	private WebDriver driver;
	private String baseUrl;
	private StudentTakeTestPOM studentPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
  
  @BeforeClass
	public void setUp() throws Exception {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		studentPOM = new StudentTakeTestPOM(driver); 
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
	    studentPOM.sendUserName("swapna9");
	    studentPOM.sendPassword("Gautham@123");
	    studentPOM.clickLoginBtn(); 
	    String expected = "Profile";
	    String actual = driver.findElement(By.linkText("Profile")).getText();
	    assertEquals(actual, expected);
   }
  
  //Student should be able to click on particular course and take test
  @Test(priority=2, dependsOnMethods="studentLogin")
   public void studentTakeTest()
   {   studentPOM.clickOnCourses();
	    studentPOM.sendSearchCourse("SELENIUM COMPLEX");
	    studentPOM.clickSearchBtn();
	    studentPOM.clickCourseLink();
	    studentPOM.clickOnTests();
	    studentPOM.clickOnTestLink();
	    studentPOM.clickOnStartTest();
	    studentPOM.selectFirstAns();
	    studentPOM.clickNextButton();
	    studentPOM.selectSecondAns();
	    studentPOM.clickOnEndTest();
	    screenShot.captureScreenShot("StudentTest");
	    String expected = "Online Quiz : Result";
	    String actual = driver.findElement(By.xpath("//H2[@class='page-header']")).getText();
	    assertEquals(actual, expected);
	    
   }
   

}

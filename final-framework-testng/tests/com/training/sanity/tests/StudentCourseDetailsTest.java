package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.StudentCourseDetailsPOM;
import com.training.pom.StudentLogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class StudentCourseDetailsTest {
	private WebDriver driver;
	private String baseUrl;
	private StudentCourseDetailsPOM coursePOM;
	private static Properties properties;
	private ScreenShot screenShot;
 
  @AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
 
  @BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	 	driver = DriverFactory.getDriver(DriverNames.CHROME);
	 	coursePOM = new StudentCourseDetailsPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

//Click on the subscribed course for student and view the course description 
@Test 
   public void searchCatalogTest()
    {
         coursePOM.sendUserName("swapna9");
         coursePOM.sendPassword("Gautham@123");
         coursePOM.clickLoginBtn(); 
         coursePOM.clickMyCourses();
         coursePOM.clickOneCourse("SELENIUM PROJECT");
         screenShot.captureScreenShot("Seventh");
     	String expected = "Selenium is an automation tool";
	 	String actual = driver.findElement(By.xpath("//P[text()='Selenium is an automation tool']")).getText();
	 	assertEquals(actual, expected);
    }


}

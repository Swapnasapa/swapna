package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CourseCatalogPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class CourseCatalogTest {
	
	private WebDriver driver;
	private String baseUrl;
	private CourseCatalogPOM catalogPOM;
	private static Properties properties;
	private ScreenShot screenShot;
 
  
  @BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		catalogPOM = new CourseCatalogPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

  @AfterMethod
 	public void tearDown() throws Exception {
 		Thread.sleep(1000);
 		driver.quit();
 	}

   @BeforeClass
 	public static void setUpBeforeClass() throws IOException {
 		properties = new Properties();
 		FileInputStream inStream = new FileInputStream("./resources/others.properties");
 		properties.load(inStream);
 	}
   
   //Search for course catalog and subscribe a course for student profile
   @Test 
	public void searchCatalogTest() {
	    catalogPOM.sendUserName("swapna9");
	    catalogPOM.sendPassword("Gautham@123");
	    catalogPOM.clickLoginBtn(); 
	    catalogPOM.clickOnCourses();
	    catalogPOM.sendSearchCourse("TestJAVA");
	    catalogPOM.clickSearchBtn();
	    catalogPOM.clickSubscribe();
	    screenShot.captureScreenShot("Third");
	   	String expectedText = "You have been registered to course: TestJAVA";
		WebElement actual = driver.findElement(By.xpath("//DIV[@class='alert alert-info']"));
		String actualText = actual.getText();
		assertEquals(actualText, expectedText);
	    
	     
	}

}

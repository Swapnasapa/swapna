package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminCategoryDBPOM;
import com.training.pom.CheckInvalidInputsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class CheckInvalidInputsTest {

	private WebDriver driver;
	private String baseUrl;
	private CheckInvalidInputsPOM checkInputsPOM;
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
		 	checkInputsPOM = new CheckInvalidInputsPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
	 
 //Admin should be able to login to elearning home page
 @Test(priority=1)
       public void aLogin(){
	        checkInputsPOM.sendUserName("admin");
	        checkInputsPOM.sendPassword("admin@123");
	        checkInputsPOM.clickLoginBtn(); 
		    String expected = "Users";
		    String actual = driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/div/div[1]")).getText();
		    assertEquals(actual, expected);
	  }
	 
//Admin should be able to verify invalid inputs while creating course and categories
@Test(priority=2)
      public void checkInvalidInputs(){
	         checkInputsPOM.clickCoursesCategories();
	         checkInputsPOM.clickAddCategory();
	         checkInputsPOM.addCategoryCode("@!");
	         checkInputsPOM.addCategoryName("");
	         checkInputsPOM.clickCourseRadio();
	         checkInputsPOM.clickAddCateBtn();
	 
	         String expected = "created";
		     String actual = driver.findElement(By.xpath("//*[@id=\"content-section\"]/div/div[2]")).getText();
		     assertEquals(actual, expected);
		     
	         checkInputsPOM.clickAdminLink();
	         checkInputsPOM.createCourseLink();
     	 
	         checkInputsPOM.sendCourseTitle("'!@##!@");
	         checkInputsPOM.sendCourseCode("");
	         checkInputsPOM.sendTeacherName("");
	         checkInputsPOM.clickCategory();
		 
	         String expected1 = "created";
		     String actual1 = driver.findElement(By.xpath("//*[@id=\"content-section\"]/div/div[2]")).getText();
		     assertEquals(actual1, expected1);
		 
	 }
}

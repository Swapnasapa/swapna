package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddMultipleUsersPOM;
import com.training.pom.AdminCategoryDBPOM;
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

public class AdminCategoryDBTest {
	
	private WebDriver driver;
	private String baseUrl;
	private AdminCategoryDBPOM DBPOM;
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
		 	DBPOM = new AdminCategoryDBPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
	 
 //Admin should be able to login to elearning home page
 @Test(priority=1)
      public void aLogin(){
	    	DBPOM.sendUserName("admin");
	    	DBPOM.sendPassword("admin@123");
	    	DBPOM.clickLoginBtn(); 
		    String expected = "Users";
		    String actual = driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/div/div[1]")).getText();
		    assertEquals(actual, expected);
	  }
	 
 //Admin should be able to verify DB for added category and courses
 @Test(dataProvider = "db-inputs1", dataProviderClass = LoginDataProviders.class, priority=2)
        public void verifyDB(String catCode, String catName, String courseTitle, String courseCode) throws InterruptedException{
		      DBPOM.clickCoursesCategories();
		      DBPOM.clickAddCategory();
		      DBPOM.addCategoryCode(catCode);
		      DBPOM.addCategoryName(catName);
		      DBPOM.clickCourseRadio();
		      DBPOM.clickAddCateBtn();
		 
		      String expected = catCode;
			  String actual = DBPOM.getCategoryCode();
			  assertEquals(actual, expected);
			     
			  DBPOM.clickAdminLink();
			  DBPOM.createCourseLink();
	     	 
			  DBPOM.sendCourseTitle(courseTitle);
			  DBPOM.sendCourseCode(courseCode);
			  DBPOM.sendTeacherName();
			  DBPOM.clickCategory();
			  
			  String expected1 = courseTitle;
			  String actual1 = DBPOM.getCourseTitle1();
			  assertEquals(actual, expected);
			  
			  DBPOM.clickAdminBtn(); 
	 }
}

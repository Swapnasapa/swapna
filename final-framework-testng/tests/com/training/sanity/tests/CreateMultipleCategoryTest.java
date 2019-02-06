package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.CreateMultipleCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class CreateMultipleCategoryTest {
	
	private WebDriver driver;
	private String baseUrl;
	private CreateMultipleCategoryPOM categoryPOM;
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
		 	categoryPOM = new CreateMultipleCategoryPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
	 
     //Admin should be able to login to elearning home page
     @Test(priority=1)
        public void aLogin(){
    	    categoryPOM.sendUserName("admin");
    	    categoryPOM.sendPassword("admin@123");
    	    categoryPOM.clickLoginBtn(); 
		    String expected = "Users";
		    String actual = driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/div/div[1]")).getText();
		    assertEquals(actual, expected);
	  }
	 
 //Admin should be able to verify DB for added category and courses
  @Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class, priority=2)
        public void addMultipleCategories(String catCode, String catName, String courseTitle, String courseCode, String teacher) throws InterruptedException{
           	 categoryPOM.clickCoursesCategories();
           	 categoryPOM.clickAddCategory();
           	 categoryPOM.addCategoryCode(catCode);
           	 categoryPOM.addCategoryName(catName);
           	 categoryPOM.clickCourseRadio();
           	 categoryPOM.clickAddCateBtn();
    	 
             categoryPOM.clickAdminLink();
             categoryPOM.createCourseLink();
         	 
             categoryPOM.sendCourseTitle(courseTitle);
             categoryPOM.sendCourseCode(courseCode);
             categoryPOM.sendTeacherName(teacher);
             categoryPOM.clickCategory();
    		 
		    String expected = courseTitle;
			String actual = driver.findElement(By.linkText(courseTitle)).getText();
			assertEquals(actual, expected);
			
			categoryPOM.clickAdminBtn(); 
	 }

}

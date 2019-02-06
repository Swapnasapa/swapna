package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminReviewStudentTestPOM;
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

public class AdminReviewStudentTest {
	private WebDriver driver;
	private String baseUrl;
	private AdminReviewStudentTestPOM reviewPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
  
  @BeforeClass
	public void setUp() throws Exception {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		reviewPOM = new AdminReviewStudentTestPOM(driver); 
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
  
  
  //Teacher should be able to login to elearning home page
  @Test(priority=1)
   public void studentLogin()
   {
	    reviewPOM.sendUserName("swapna9");
	    reviewPOM.sendPassword("Gautham@123");
	    reviewPOM.clickLoginBtn(); 
	    String expected = "Profile";
	    String actual = driver.findElement(By.linkText("Profile")).getText();
	    assertEquals(actual, expected);
   }
  
//Teacher should be able to click on particular course and create test
  @Test(priority=2, dependsOnMethods="studentLogin")
   public void teacherCreateTest()
   {    reviewPOM.clickOnCourses();
        reviewPOM.sendSearchCourse("SELENIUM COMPLEX");
        reviewPOM.clickSearchBtn();
        reviewPOM.clickCourseLink();
        reviewPOM.clickOnTests();
        reviewPOM.clickCreateTest();
        reviewPOM.clickLogout();
	    
   }
  
  //Student should be able to click on particular course and take test
  @Test(priority=3)
   public void studentTakeTest()
   {  
	    reviewPOM.sendUserName("swapna9");
	    reviewPOM.sendPassword("Gautham@123");
	    reviewPOM.clickLoginBtn(); 
	    reviewPOM.clickOnCourses();
        reviewPOM.sendSearchCourse("SELENIUM COMPLEX");
        reviewPOM.clickSearchBtn();
        reviewPOM.clickCourseLink();
        reviewPOM.clickOnTests();
        reviewPOM.clickOnTestLink();
        reviewPOM.clickOnStartTest();
        reviewPOM.selectFirstAns();
        reviewPOM.clickNextButton();
        reviewPOM.selectSecondAns();
        reviewPOM.clickOnEndTest();
	    screenShot.captureScreenShot("StudentTest");
	    String expected = "online quiz : Result";
	    String actual = driver.findElement(By.xpath("//H2[@class='page-header']")).getText();
	    assertEquals(actual, expected);
	    reviewPOM.clickLogout();
	    
   }
  
  //Admin should be able to review test and send mail
  @Test(priority=4)
   public void adminReviewTest()
   {  
	    reviewPOM.sendUserName("admin");
	    reviewPOM.sendPassword("admin@123");
	    reviewPOM.clickLoginBtn(); 
	    reviewPOM.clickReportingBtn(); 
	    reviewPOM.followedStdntsLink();
	    reviewPOM.performAdminReview();
	    String expected = "Message Sent";
	    String actual = driver.findElement(By.xpath("//*[@id=\"content-section\"]/div/div[2]")).getText();
        assertEquals(actual, expected);
        driver.findElement(By.linkText("Seleniumfortesting")).click();
   }
   


}

package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.TeacherPasswordResetPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class TeacherPasswordResetTest {
	private WebDriver driver;
	private String baseUrl;
	private TeacherPasswordResetPOM teacherPOM;
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
		teacherPOM = new TeacherPasswordResetPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
 
 //Reset the password for Teachers login using i lost my password link in login page
 @Test(priority=1)
    public void resetPasswordTest() throws InterruptedException {
	  teacherPOM.clickLostPassword(); 
	  teacherPOM.enterUsername("swapna18");
	  teacherPOM.clickSendMsgBtn();
	  teacherPOM.checkMsg();
	  try {
		screenShot.captureScreenShot("Fourth");
	} catch (Exception e) {
	 	e.printStackTrace();
	}
	  Thread.sleep(10000);
	  driver.get("https://gmail.com");
	  teacherPOM.loginMyGmailid("testpurpose774");
	  teacherPOM.clickNext1();
	  teacherPOM.loginMyGmail("Gautham@143");
	  teacherPOM.clickNext2();
	  teacherPOM.checkMailForPassword();
	  teacherPOM.checkPasswordLink();
	  Thread.sleep(10000);
	   driver.navigate().to("https://gmail.com");
	  teacherPOM.checkMailForPassword();
	  teacherPOM.getPassword();
	 
	 }
 
 //Login with username and new password for Teachers profile
 @Test(priority=2)
 public void testTeacherLogin() {
	  driver.get("http://elearning.hommelle.com");
	  teacherPOM.sendLoginName("swapna18");
	  teacherPOM.sendPassword();
	  teacherPOM.clickLoginBtn(); 
	  screenShot.captureScreenShot("Fifth");
	  
	  String expected = "Hello swapna reddy and welcome,";
	  String actual = driver.findElement(By.xpath("(//P)[3]")).getText();
	  assertEquals(actual, expected);
		
   }


}

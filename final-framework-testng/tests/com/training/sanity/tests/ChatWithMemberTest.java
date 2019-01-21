package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChatWithMemberPOM;
import com.training.pom.CreateThreadPOM;
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

public class ChatWithMemberTest {
	private WebDriver driver;
	private String baseUrl;
	private ChatWithMemberPOM chatPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
  
  @BeforeClass
	public void setUp() throws Exception {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		chatPOM = new ChatWithMemberPOM(driver); 
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
	    chatPOM.sendUserName("swapna9");
	    chatPOM.sendPassword("Gautham@123");
	    chatPOM.clickLoginBtn(); 
	    String expected = "Profile";
	    String actual = driver.findElement(By.linkText("Profile")).getText();
	    assertEquals(actual, expected);
   }
  
  //Student should be able to click on particular course and take test
  @Test(priority=2, dependsOnMethods="studentLogin")
   public void sendMessage() throws InterruptedException 
   {  
	    chatPOM.clickOnCourses();
	    chatPOM.sendSearchCourse("SELENIUM PROJECT");
	    chatPOM.clickSearchBtn();
	    chatPOM.clickCourseLink();
	    chatPOM.clickOnGroups();
	    chatPOM.clickAssignedGroup();
	    chatPOM.clickChatImg();
	    chatPOM.clickMemberToChat();
	    screenShot.captureScreenShot("ChatWindow");
	    String expected = "manzoor mehadi";
	    String actual = driver.findElement(By.xpath("//*[@id=\"chat-tab-4\"]")).getText();
        Assert.assertEquals(actual, expected);
   }


}

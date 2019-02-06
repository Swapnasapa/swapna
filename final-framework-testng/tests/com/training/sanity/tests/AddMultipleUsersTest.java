package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddMultipleUsersPOM;
import com.training.pom.ExcelReadPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class AddMultipleUsersTest {
	private WebDriver driver;
	private String baseUrl;
	private AddMultipleUsersPOM usersPOM;
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
		usersPOM = new AddMultipleUsersPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
 
//Admin should be able to login to elearning home page
 @Test(priority=1)
  public void studentLogin()
  {
	    usersPOM.sendUserName("admin");
	    usersPOM.sendPassword("admin@123");
	    usersPOM.clickLoginBtn(); 
	    String expected = "Users";
	    String actual = driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/div/div[1]")).getText();
	    assertEquals(actual, expected);
  }
 

//admin to add multiple users with different roles
@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class, priority=2)
 public void addMultipleUsers(String firstname, String lastname, String email, String login, String password, String role) {
        usersPOM.clickAddUserBtn(); 
	    usersPOM.sendFirstname(firstname);
	    usersPOM.sendLastname(lastname);
	    usersPOM.sendEmail(email);
	    usersPOM.sendLoginName(login);
	    usersPOM.selectPasswordButton();
	    usersPOM.sendUserPassword(password); 
	    WebElement userRole = driver.findElement(By.xpath("(//BUTTON[@type='button'])[2]"));
	    userRole.click();
	    if(firstname.equalsIgnoreCase("manzoor"))
	    {
	    driver.findElement(By.xpath("//*[@id=\"user_add\"]/fieldset/div[11]/div[1]/div/div/ul/li[5]/a")).click();
	    }
	    else if(firstname.equalsIgnoreCase("alex"))
	    {
	    driver.findElement(By.xpath("//*[@id=\"user_add\"]/fieldset/div[11]/div[1]/div/div/ul/li[1]/a")).click();
	    }
	    else if(firstname.equalsIgnoreCase("george"))
	    {
	     driver.findElement(By.xpath("//*[@id=\"user_add\"]/fieldset/div[11]/div[1]/div/div/ul/li[6]/a")).click();
	    }
	    else if(firstname.equalsIgnoreCase("mark"))
	    {
	     driver.findElement(By.xpath("//*[@id=\"user_add\"]/fieldset/div[11]/div[1]/div/div/ul/li[4]/a")).click();
	    }
	    usersPOM.clickAddBtn(); 
	   
		screenShot.captureScreenShot("MyExcel");
 		String expected = "The user has been added:"+firstname+" "+lastname+"";
		String actual = driver.findElement(By.xpath("//*[@id=\"content-section\"]/div/div[2]/div/div[2]")).getText();
		assertEquals(actual, expected);
		
		 usersPOM.clickAdminBtn(); 
	 
        }

}

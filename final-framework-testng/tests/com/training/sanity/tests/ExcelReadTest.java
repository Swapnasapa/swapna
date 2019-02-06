package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
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
import org.testng.annotations.AfterTest;

public class ExcelReadTest {
	private WebDriver driver;
	private String baseUrl;
	private ExcelReadPOM excelPOM;
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
		excelPOM = new ExcelReadPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

//Login with student username and password and try to logout from the account
@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
        public void studentLogout(String username, String password) {
	    excelPOM.sendUserName(username);
	    excelPOM.sendPassword(password);
	    excelPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("MyExcel");
		excelPOM.clickLogout();
		String expected = "Login";
		String actual = driver.findElement(By.id("formLogin_submitAuth")).getText();
		assertEquals(actual, expected);
	 
        }


}

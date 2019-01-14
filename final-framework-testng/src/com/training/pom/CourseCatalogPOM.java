package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseCatalogPOM {
	
private WebDriver driver; 
	
	public CourseCatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//A[@href='main/auth/courses.php']")
    private WebElement courses;
	
	@FindBy(name="search_term")
    private WebElement searchCourse;
	
	@FindBy(xpath="//BUTTON[@class='btn btn-default']")
	private WebElement searchBtn;
	
	@FindBy(xpath="(//A[@class='btn btn-success btn-sm'])[1]")
	private WebElement subscribe;
	

	@FindBy(xpath="//DIV[@class='alert alert-info']")
	private WebElement finalText;
	
	public void sendUserName(String string) {
		this.userName.clear();
		this.userName.sendKeys(string);
		
	}

	public void sendPassword(String string) {
		this.password.clear(); 
		this.password.sendKeys(string); 
		
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
		
	}

	public void clickOnCourses() {
		this.courses.click();
		
	}

	public void sendSearchCourse(String string) {
		this.searchCourse.clear();
		this.searchCourse.sendKeys(string);
		
	}
	
	public void clickSearchBtn() {
	 	this.searchBtn.click();
		
	}
	
	public void clickSubscribe() {
	 	this.subscribe.click();
		
	}


}

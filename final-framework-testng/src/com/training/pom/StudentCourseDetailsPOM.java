package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StudentCourseDetailsPOM {
	private WebDriver driver; 
	private String useCourse;

	public StudentCourseDetailsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"menuone\"]/ul[1]/li[2]/a")
	private WebElement mycourses;
	
	@FindBy(linkText="Course description")
	private WebElement courseDescription;
	
	@FindBy(xpath="//P[text()='Selenium is an automation tool']")
	private WebElement finalText;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickMyCourses() {
		this.mycourses.click(); 
	}

	public void clickOneCourse(String course1) {
	 	driver.findElement(By.linkText(course1)).click();
	 	this.courseDescription.click(); 
	}
	
	

}

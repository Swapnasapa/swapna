package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadAssignmentPOM {
private WebDriver driver; 
	
	public UploadAssignmentPOM(WebDriver driver) {
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

	@FindBy(xpath="//A[@title='SELENIUM PROJECT'][text()='SELENIUM PROJECT']")
	private WebElement courseLink;

	@FindBy(linkText="Assignments")
	private WebElement assignments;

	@FindBy(linkText="Hands on exercises")
	private WebElement availAssignment;

	@FindBy(xpath="//*[@id=\"toolbar-work\"]/div/div[2]/a")
	private WebElement upload;
	
	 
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

	public void clickCourseLink() {
		this.courseLink.click();
		
	}

	public void clickOnAssignmentsLink() {
		this.assignments.click();
		
	}

	public void clickAvailAssignments() {
		this.availAssignment.click();
		
	}

	public void uploadAssignment() {
		this.upload.click();
		
	}

 
}

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentTakeTestPOM {
	
private WebDriver driver; 
	
	public StudentTakeTestPOM(WebDriver driver) {
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

	@FindBy(linkText="Tests")
	private WebElement tests;

	@FindBy(linkText="Online Quiz")
	private WebElement testLink;
	
	@FindBy(xpath="//A[@class='btn btn-success btn-large'][text()='Start test']")
	private WebElement startTest;

	@FindBy(id="choice-130-1")
	private WebElement firstAns;
	
	@FindBy(xpath="//*[@id=\"question_div_130\"]/div[3]/button")
	private WebElement clickNext;
	
	@FindBy(id="choice-131-2")
	private WebElement secondAns;
	
	@FindBy(xpath="//*[@id=\"question_div_131\"]/div[3]/button[2]")
	private WebElement endTest;
	
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

	public void clickOnTests() {
		this.tests.click();
		
	}

	public void clickOnTestLink() {
		this.testLink.click();
		
	}
	
	public void clickOnStartTest() {
		this.startTest.click();
		
	}

	public void selectFirstAns() {
	 this.firstAns.click();
		
	}
	


	public void selectSecondAns() {
	 this.secondAns.click();
		
	}
	
	public void clickOnEndTest() {
		this.endTest.click();
		
	}

	public void clickNextButton() {
		this.clickNext.click();
		
	}

}

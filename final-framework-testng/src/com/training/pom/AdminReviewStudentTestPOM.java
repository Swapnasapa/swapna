package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminReviewStudentTestPOM {
	
private WebDriver driver; 
	
	public AdminReviewStudentTestPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	 		
	}
	
	@FindBy(xpath="//*[@id=\"login\"]")
	private WebElement userName; 
	
	@FindBy(xpath="//*[@id=\"password\"]")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//A[@href='main/auth/courses.php']")
    private WebElement courses;
	
	@FindBy(name="search_term")
    private WebElement searchCourse;
	
	@FindBy(xpath="//BUTTON[@class='btn btn-default']")
	private WebElement searchBtn;

	@FindBy(xpath="//A[@title='SELENIUM COMPLEX'][text()='SELENIUM COMPLEX']")
	private WebElement courseLink;

	@FindBy(linkText="Tests")
	private WebElement tests;

	@FindBy(linkText="online quiz1")
	private WebElement testLink;
	
	@FindBy(xpath="//A[@class='btn btn-success btn-large'][text()='Start test']")
	private WebElement startTest;

	@FindBy(xpath="//*[@id=\"choice-29-1\"]")
	private WebElement firstAns;
	
	@FindBy(xpath="//*[@id=\"question_div_29\"]/div[3]/button")
	private WebElement clickNext;
	
	@FindBy(xpath="//*[@id=\"choice-30-2\"]")
	private WebElement secondAns;
	
	@FindBy(xpath="//*[@id=\"question_div_30\"]/div[3]/button[2]")
	private WebElement endTest;

	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/a[1]/img")
	private WebElement createTest;
	
	@FindBy(id="exercise_title")
	private WebElement title;

	@FindBy(id="advanced_params")
	private WebElement advancedBtn;

	@FindBy(xpath="//*[@id=\"no-data-view\"]/div/a")
	private WebElement createNewTest;

	@FindBy(xpath="exerciseFeedbackType")
	private WebElement checkBox;

	@FindBy(name="activate_start_date_check")
	private WebElement dateCheckBox;

	@FindBy(id="pass_percentage")
	private WebElement percentage;

	@FindBy(name="submitExercise")
	private WebElement proceedQues;

	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[5]/ul/li[1]/div/a/img")
	private WebElement mulitpleImg;

	@FindBy(name="questionName")
	private WebElement firstQues;

	@FindBy(xpath="//*[@id=\"question_admin_form_questionName\"]")
	private WebElement secondQues;
	
	@FindBy(xpath="(//*[@class='img-circle'])[1]")
	private WebElement logoutBtn; 
	
	@FindBy(xpath="//*[@id='logout_button']")
	private WebElement clickBtn;

	@FindBy(linkText="Reporting")
	private WebElement reporting;

	@FindBy(linkText="Followed students")
	private WebElement followedStdnts;

	@FindBy(xpath="//*[@id=\"search_user_keyword\"]")
	private WebElement searchStdnt;

	@FindBy(xpath="//*[@id=\"search_user_submit\"]")
	private WebElement search;

	@FindBy(xpath="//IMG[@src='http://elearning.upskills.in/main/img/icons/22/2rightarrow.png']")
	private WebElement userDetails;

	@FindBy(xpath="(//IMG[@src='http://elearning.upskills.in/main/img/icons/22/2rightarrow.png'])[1]")
	private WebElement courseDetails;

	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[4]/table/tbody/tr/td[5]/a/img")
	private WebElement lastAttempt;

	@FindBy(xpath="//*[@name='send_notification']")
	private WebElement sendEmail;

	@FindBy(xpath="//*[@id=\"myform_submit\"]")
	private WebElement correctText; 
	
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

	public void clickCreateTest() {
		this.createTest.click();
		
 		this.title.clear();
		this.title.sendKeys("online quiz1");
		
		this.advancedBtn.click();
		
		List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(0);
	    WebElement body = driver.findElement(By.tagName("body"));
	    body.sendKeys("quiz");
	    driver.switchTo().defaultContent();
	   	    
	    this.dateCheckBox.click();
	    
	    this.percentage.click();
	    
	    this.proceedQues.click();
	    
	    this.mulitpleImg.click();
		
	    this.firstQues.clear();
	    this.firstQues.sendKeys("Which project you are doing");
	    
	    List<WebElement> frameList1 = driver.findElements(By.tagName("iframe"));
	    System.out.println("No. of frames : "+frameList1);
	    driver.switchTo().frame(1);
	    WebElement body1 = driver.findElement(By.tagName("body"));
	    body1.sendKeys("Selenium");
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(3);
	    WebElement body2 = driver.findElement(By.tagName("body"));
	    body2.sendKeys("Java");
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(5);
	    WebElement body3 = driver.findElement(By.tagName("body"));
	    body3.sendKeys("C");
	    driver.switchTo().defaultContent();
	    
	    driver.switchTo().frame(7);
	    WebElement body4 = driver.findElement(By.tagName("body"));
	    body4.sendKeys("C#");
	    driver.switchTo().defaultContent();
	    
	    List<WebElement> radio = driver.findElements(By.name("correct"));
	    radio.get(0).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"submit-question\"]")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"content-section\"]/div/div[5]/ul/li[1]/div/a/img")).click();
	    this.secondQues.clear();
	    this.secondQues.sendKeys("Which language you are using in selenium");
	    
	    List<WebElement> frameList2 = driver.findElements(By.tagName("iframe"));
	    driver.switchTo().frame(1);
	    WebElement body5 = driver.findElement(By.tagName("body"));
	    body5.sendKeys("Pyhton");
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(3);
	    WebElement body6 = driver.findElement(By.tagName("body"));
	    body6.sendKeys("Java");
	    driver.switchTo().defaultContent();
	    driver.switchTo().frame(5);
	    WebElement body7 = driver.findElement(By.tagName("body"));
	    body7.sendKeys("C");
	    driver.switchTo().defaultContent();
	    
	    driver.switchTo().frame(7);
	    WebElement body8 = driver.findElement(By.tagName("body"));
	    body8.sendKeys("C#");
	    driver.switchTo().defaultContent();
	    
	    List<WebElement> radio1 = driver.findElements(By.name("correct"));
	    radio1.get(1).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"submit-question\"]")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"content-section\"]/div/div[3]/a[2]/img")).click();
	}
	
	public void clickLogout() {
		this.logoutBtn.click();
		this.clickBtn.click();
		
		
	}

	public void clickReportingBtn() {
		this.reporting.click();
		
	}

	public void followedStdntsLink() {
		this.followedStdnts.click();
		
	}

	public void performAdminReview() {
		this.searchStdnt.clear();
		this.searchStdnt.sendKeys("sunil");
		
		this.search.click();
		
		this.userDetails.click();
		
		this.courseDetails.click();
		  
		this.lastAttempt.click();
		
	    this.sendEmail.click();
		this.correctText.click();
		
		
	}

}

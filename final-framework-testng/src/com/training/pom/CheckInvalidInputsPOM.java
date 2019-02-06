package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckInvalidInputsPOM {
private WebDriver driver; 
	
	public CheckInvalidInputsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private String teacher; 
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn;
	
	@FindBy(linkText="Courses categories")
	private WebElement coursesCatBtn;
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/a/img")
	private WebElement addCat;
	
	@FindBy(id="course_category_code")
	private WebElement cateCode;

	@FindBy(id="course_category_name")
	private WebElement cateName;

	@FindBy(id="qf_a99fd4")
	private WebElement addCourseRadio;

	@FindBy(id="course_category_submit")
	private WebElement addCateBtn;

	@FindBy(linkText="Administration")
	private WebElement clickAdmin;

	@FindBy(linkText="Create a course")
	private WebElement createCourse;

	@FindBy(id="update_course_title")
	private WebElement courseTitle;

	@FindBy(id="visual_code")
	private WebElement courseCode;

	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[3]/div[1]/div/button")
	private WebElement teacherName;

	 @FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[3]/div[1]/div/div/ul/li[3]/a")
	private WebElement selectTeacher;

	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[4]/div[1]/div/button/span[1]")
	private WebElement catName;

	@FindBy(xpath="//SPAN[@class='text'][text()='(OL) Online Learning']")
	private WebElement selectCat;

	@FindBy(id="update_course_submit")
	private WebElement clickCourseBtn; 
	
	
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
	
	public void clickCoursesCategories() {
		this.coursesCatBtn.click();
		
	}
	
	public void clickAddCategory() {
		this.addCat.click();
		
	}
	
	public void addCategoryCode(String string) {
		this.cateCode.clear();
		this.cateCode.sendKeys(string);
		
	}

	public void addCategoryName(String string) {
		this.cateName.clear();
		this.cateName.sendKeys(string);
		
	}

	public void clickCourseRadio() {
		List<WebElement> addCourseRadio = driver.findElements(By.name("auth_course_child"));
		addCourseRadio.get(0).click();
		
	}

	public void clickAddCateBtn() {
		this.addCateBtn.click();
		
	}

	public void clickAdminLink() {
		this.clickAdmin.click();
		
	}

	public void createCourseLink(){
		this.createCourse.click();
	}

	public void sendCourseTitle(String string) {

		this.courseTitle.clear();
		this.courseTitle.sendKeys(string);
	}

	public void sendCourseCode(String string) {
		this.courseCode.clear();
		this.courseCode.sendKeys(string);
	}
	
	public void sendTeacherName(String string) {

		this.teacher = string;
		System.out.println("teacher: "+this.teacher);
		this.teacherName.click();
		this.selectTeacher.click();

	}

	public void clickCategory() {
		this.catName.click();	
		this.selectCat.click();
	 	
		this.clickCourseBtn.click();
		
	}
	
	public void clickAdminBtn() {
		this.clickAdmin.click();
		
	}

}

package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 
public class CreateThreadPOM {
private WebDriver driver; 
	
	public CreateThreadPOM(WebDriver driver) {
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

	@FindBy(linkText="Forums")
	private WebElement forums;

	@FindBy(linkText="Group 0001")
	private WebElement grouplink;

	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/a[2]/img")
	private WebElement openThread;

	@FindBy(name="post_title")
	private WebElement title;

	@FindBy(xpath="(//P)[1]")
	private WebElement text;
	
	@FindBy(id="thread_SubmitPost")
	private WebElement submitThread;

	@FindBy(xpath="//*[contains(@id, 'reply-to-post')]")
	private WebElement reply;
	
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

	public void clickOnForums() {
		this.forums.click();
		
	}

	public void clickAssignedGroup() {
		this.grouplink.click();
		
	}

	public void clickCreateThread() {
		this.openThread.click();
		
	}

	public void threadTitle() {
		this.title.clear();
		this.title.sendKeys("Testcase9");
		
	}

	public void threadText() {
	 
	   List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
	   driver.switchTo().frame(0);
       WebElement body = driver.findElement(By.tagName("body"));
       body.sendKeys("Need Help");
       driver.switchTo().defaultContent();
 
 	}

	public void threadSubmit() {
		this.submitThread.click();
		
	}

	public void replyThread() {
		this.reply.click();
		
	}

	public void writeReplyMsg() throws InterruptedException {
		List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		System.out.println("list of frames"+frameList.size());
		   driver.switchTo().frame(0);
		   Thread.sleep(5000);
	       WebElement body = driver.findElement(By.tagName("body"));
	       Thread.sleep(5000);
	      new Actions(driver).moveToElement(body).click().sendKeys("Take Google Help").build().perform();
	       driver.switchTo().defaultContent();
		
	}

}
